import { createContext, useContext, useEffect, useState } from "react";
import stompClient from "./StompClient";

const StompContext = createContext(null);

export function StompProvider({ children }) {
  const [connected, setConnected] = useState(false);
  const [subscriptions, setSubscriptions] = useState({}); // ✅ 채팅방별 구독 정보 저장

  useEffect(() => {
    stompClient.onConnect = () => {
      console.log("✅ STOMP Connected");
      setConnected(true);
    };

    stompClient.onDisconnect = () => {
      console.log("❌ STOMP Disconnected");
      setConnected(false);
    };

    stompClient.activate(); // ✅ STOMP 클라이언트 활성화

    return () => {
      stompClient.deactivate(); // ✅ 컴포넌트 언마운트 시 STOMP 연결 해제
    };
  }, []);

  // ✅ 채팅방 구독 (chatRoomId 기준)
  
  const subscribeToRoom = (chatRoomId, callback) => {
    if (!connected) return;

    const subscription = stompClient.subscribe(`/topic/chat/${chatRoomId}`, (message) => {
      callback(JSON.parse(message.body));
    });

    setSubscriptions((prev) => ({
      ...prev,
      [chatRoomId]: subscription,
    }));
  };

  // ✅ 특정 채팅방 구독 취소
  const unsubscribeFromRoom = (chatRoomId) => {
    if (subscriptions[chatRoomId]) {
      subscriptions[chatRoomId].unsubscribe();
      setSubscriptions((prev) => {
        const updatedSubs = { ...prev };
        delete updatedSubs[chatRoomId];
        return updatedSubs;
      });
    }
  };

  return (
    <StompContext.Provider value={{ connected, subscribeToRoom, unsubscribeFromRoom }}>
      {children}
    </StompContext.Provider>
  );
}

// ✅ Context 사용을 쉽게 하기 위한 커스텀 훅

export function useStomp() {
  const context = useContext(StompContext);
  if (!context) {
    throw new Error("❌ useStomp must be used within a StompProvider");
  }
  return context;
}