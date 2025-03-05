import chatBasixAxios from '../common/ChatAxios';
import { useState } from 'react';
import './ChatRoom.css';
import { v4 as uuidv4 } from 'uuid';
import stompClient from '../stomp/StompClient';
import  { useStomp } from '../stomp/stompContext';

export default function ChatRoom() {

    const [messages, setMessages] = useState([]);
    const [inputText, setInputText] = useState("");
    const [selectedChat, setSelectedChat] = useState(null); 
    
    useEffect(() => {
        if (!connected) return;
    
        const handleNewMessage = (newMessage) => {
          setMessages((prevMessages) => [...prevMessages, newMessage]);
        };
    
        subscribeToRoom("1234", handleNewMessage);
    
        return () => {
          unsubscribeFromRoom("1234"); // ✅ 채팅방 변경 시 구독 해제
        };
      }, [connected, "1234"]);

    const handleSendMessage = () => {
        console.log("send btn click");
        if(!inputText.trim()) return;
        const newMsg = {
          sender: "ksswy",
          value : inputText.trim(),
          date : new Date().toLocaleTimeString([], {hour:"2-digit",minute:"2-digit"}),
          type : "1",
          roomId : "1234",
          chatId: uuidv4()
        };
        stompClient.publish({
          destination :"/app/private-message",
          body:JSON.stringify(newMsg)
        })
        setInputText("");//초기화
    }

    return (
        <div>
             {/* 채팅 헤더 */}
            <div className="chat-header">
            <div className="chat-avatar">D</div>
            <div className="chat-header-title">
                {selectedChat ? selectedChat.name : "No Chat Selected"}
            </div>
            </div>

            {/* 메시지 목록 */}
            <div className="chat-messages">
            {messages.map((msg, idx) => {
                const isMe = msg.sender === "ksswy";
                return (
                <div
                    key={idx}
                    className={`message ${isMe ? "message-right" : "message-left"}`}
                >
                    <div className="message-content">
                    <div>{msg.value}</div>
                    <div className="message-time">{msg.date}</div>
                    </div>
                </div>
                );
            })}
            </div>

            {/* 메시지 입력 */}
            <div className="chat-input">
            <input
                type="text"
                placeholder="Write a message..."
                value={inputText}
                onChange={(e) => setInputText(e.target.value)}
                onKeyDown={(e) => {
                if (e.key === "Enter") handleSendMessage();
                }}
            />
            <button onClick={handleSendMessage}>Send</button>
            </div>
        </div>
    );
}