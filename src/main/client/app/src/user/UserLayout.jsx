import React, { useEffect, useState } from "react";
import axios from 'axios';
import "./UserLayout.css";



const usersData = [
    {
      group: "Designers",
      members: [
        { 
          id: 1, 
          name: "Alice", 
          avatar: "https://i.pravatar.cc/40?img=1",
          position: "UI Designer",
          comment: "Working on new features"
        },
        { 
          id: 2, 
          name: "Bob", 
          avatar: null,
          position: "UX Designer",
          comment: "Available for collaboration" 
        },
      ],
    },
    {
      group: "Developers",
      members: [
        { 
          id: 3, 
          name: "Charlie", 
          avatar: "https://i.pravatar.cc/40?img=3",
          position: "Frontend Developer",
          comment: "React specialist" 
        },
        { 
          id: 4, 
          name: "David", 
          avatar: "https://i.pravatar.cc/40?img=4",
          position: "Backend Developer",
          comment: "Working on API" 
        },
        { 
          id: 5, 
          name: "Eve", 
          avatar: null,
          position: "Full Stack Developer",
          comment: "On vacation" 
        },
      ],
    },
  ];

export default function UserList(){
    const [openGroups, setOpenGroups] = useState({});
    const server_url  = window.location.protocol +"//"+ window.location.hostname+":8090"

    const toggleGroup = (groupName) => {
        setOpenGroups((prev) => ({
          ...prev,
          [groupName]: !prev[groupName],
        }));
      }

    useEffect(() => {
        axios.get(server_url+"/getUserList",{userId:"ksswy"})
        .then((response) => {
            console.log(response);
        })
        .catch((error) => {
            console.error("사용자 목록을 가져오는 중 오류 발생: ", error);
        });
    }, []);

    return(
        <div className="chat-list">
            {usersData.map((group) => (
                <div key={group.group} className="user-group">
                <div className="group-header" onClick={() => toggleGroup(group.group)}>
                    <span className="group-name">{group.group}</span>
                    <span className={`arrow ${openGroups[group.group] ? "open" : ""}`}>
                    ▼
                    </span>
                </div>
                {openGroups[group.group] && (
                    <ul className="user-items">
                    {group.members.map((user) => (
                        <li key={user.id} className="user-item">
                        <div className="user-profile">
                            {user.avatar ? (
                            <img src={user.avatar} alt={user.name} className="user-avatar" />
                            ) : (
                            <span className="default-icon">👤</span>
                            )}
                            <div className="user-info">
                            <div className="user-name-position">
                                <span className="user-name">{user.name}</span>
                                <span className="user-position">{user.position}</span>
                            </div>
                            <div className="user-comment">{user.comment}</div>
                            </div>
                        </div>
                        </li>
                    ))}
                    </ul>
                )}
                </div>
            ))}
        </div>
    )
}
