import React, { useEffect, useState } from "react";
import { Client } from "@stomp/stompjs";
import SockJS from "sockjs-client";
import "./Messenger.css";
import UserLayout from "../user/UserLayout";
import ChatRoom from "../chat/ChatRoom";
import ChatList from "../chat/ChatList";
import { useUser } from "../common/UserContext";
import { StompProvider } from "../stomp/stompContext";


export default function DesktopMessenger() {
  const [selectedChat, setSelectedChat] = useState(null); // 초기 선택 없음
  const [messages, setMessages] = useState([]); // 초기 메시지 없음
  const [stompClient, setStompClient] = useState(null);
  const [selectMenu, setSelectMenu] = useState(null);
  const [selectedChatId ,selectChatUser] = useState(null);

  console.log(useUser());
  console.log(selectedChatId);
  const server_url  = window.location.protocol +"//"+ window.location.hostname+":8090"
  useEffect(()=>{
    const socket = new SockJS( server_url+"/ws")
    const client = new Client({
      webSocketFactory: () => socket,
      connectHeaders :{userId: "ksswy"},
      onConnect: () =>{
        console.log("Connect to webSocket");

        client.subscribe("/queue/room/1234",(message) => {
          console.log("message reiceve");
          const receiveMessage = JSON.parse(message.body);
          console.log(receiveMessage);
          setMessages((prev) => [...prev, receiveMessage])

        })
      },
      onDisconnect: () => console.log("Disconnect")
    })
    client.activate();
    setStompClient(client);

    return () => client.deactivate(); // 컴포넌트 언마운트 시 연결 해제
  },[]);



  const handleMenuUserClick = () => {
    setSelectMenu("userList");
    setMessages([]); // 사용자 목록 클릭 시 메시지 목록 비우기
  }

  const handleMenuChatClick = () =>{
    setSelectMenu("chatList")
  }

  // 사이드바에서 채팅 목록 클릭 시
  const handleSelectChat = (chat) => {
    setSelectedChat(chat);
    // 서버에서 해당 채팅에 대한 메시지를 불러오는 로직 필요
    // 예시: setMessages(fetchMessagesForChat(chat));
    //setMessages(initialMessages); // 임시로 초기 메시지 설정
  };

  return (
    <div className="messenger-container">
      {/* 왼쪽 사이드바 */}
      <div className="sidebar">
        <div className="sidebar-header">Messenger</div>
        <div className="sidebar-menu-container">
          <div className={`sidebar-menu ${  (selectMenu  ===  "userList" || !selectMenu)?"active":""}`} 
          onClick={handleMenuUserClick}>사용자 목록</div>
          <div className={`sidebar-menu ${selectMenu  ===  "chatList"?"active":""}`}
          onClick={handleMenuChatClick}>대화방 목록</div>
        </div>
        <input className="search-box" placeholder="Search" />
        {(selectMenu  ===  "userList"  || !selectMenu)&& (
          <UserLayout selectChatUser={selectChatUser}/>
        )}
        {selectMenu === "chatList" && (
            <ChatList/>
        )}
      </div>
      {/* 채팅창 */}
      <div className="chat-window">
        <StompProvider>
          <ChatRoom chatRoomtId={selectedChatId}/>
        </StompProvider>
      </div>

    </div>
  );
}
