import React, { useEffect, useState } from "react";
import axios from 'axios';
import "./ChatList.css";



var chatListData = [
    {
      name: "Saved 222",
      lastMessage: "Used for gradient stops in elevation",
      time: "9:54 PM",
    },
    {
      name: "Designers",
      lastMessage: "You: 🎙️ Poll",
      time: "4:27 PM",
    },
    {
      name: "Cody Fisher",
      lastMessage: "I'll be there in 2 mins",
      time: "10:12 AM",
    },
    {
      name: "Albert Flores",
      lastMessage: "aww",
      time: "Tue",
    },
    {
      name: "Bessie Cooper",
      lastMessage: "Haha that's terrifying 😂",
      time: "Tue",
    },
    {
      name: "Ronald Richards",
      lastMessage: "Sure, let's do it!",
      time: "Mon",
    },
    {
      name: "Ralph Edwards",
      lastMessage: "Any updates?",
      time: "Mon",
    },
  ];

  const initialMessages = [
    {
      sender: "Designers",
      message: `To check out what a native Windows Telegram app looks like, you can try Unigram. It is possible that the best design solutions will be implemented into Unigram. To check the functionality of Telegram desktop apps, please refer to https://desktop.telegram.org`,
      date: "9:54 PM",
    },
    {
      sender: "You",
      message: "What do you think?",
      date: "9:54 PM",
    },
  ];

export default function ChatList(){

    setInputText("");//초기화

    const [chatListData1, setChatListData] = useState([]);
    const [inputText, setInputText] = useState("");
    const [selectedChat, setSelectedChat] = useState(chatListData[1]); // 기본 선택: "Designers"
    const [messages, setMessages] = useState(initialMessages);
    // 사이드바에서 채팅 목록 클릭 시
    const handleSelectChat = (chat) => {
        setSelectedChat(chat);
        // 실제로는 서버에서 해당 채팅에 대한 메시지를 불러오는 로직이 필요
        setMessages(initialMessages);
    };



  // useEffect에서 axios를 사용하여 사용자 목록을 가져옴
  useEffect(() => {
    // 실제 API 엔드포인트 URL로 변경하세요.
    axios.post(server_url+"/getUserList",{userId:"ksswy"})
      .then((response) => {
        console.log(response);
        // response.data가 사용자 목록 배열이라고 가정합니다.
        setChatListData(response.data);
      })
      .catch((error) => {
        console.error("사용자 목록을 가져오는 중 오류 발생: ", error);
      });
  }, []);

    return(
        <div className="chat-list">
            {chatListData.map((chat, idx) => (
              <div
                key={idx}
                className="chat-item"
                onClick={() => handleSelectChat(chat)}
                >
                <div className="chat-avatar">
                    {chat.name.charAt(0)}
                </div>
                <div className="chat-info">
                    <div className="chat-name">{chat.name}</div>
                    <div className="chat-last-message">{chat.lastMessage}</div>
                </div>
                <div className="chat-time">{chat.time}</div>
            </div>
          ))}
      </div>
    )
}


