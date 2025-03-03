import React, { useEffect, useRef,  useState } from "react";
import "./UserLayout.css";
import chatBasixAxios from '../common/ChatAxios';

/**
 * 사용자 목록 조회
 * 
 * 
 */
let myProfile = {comment: "나의 코멘트1",
dept: null,
id: null,
name: "김상우",
password: null,
position: "직책1",
profileImg: "https://i.pravatar.cc/40?img=50",
userId:"ksswy"};
export default function UserList(){
    const [openGroups, setOpenGroups] = useState({});
    const [usersData, setUsersData] = useState([]);
    const [myProfile, setMyProfile] = useState(null);
    const calledOnce = useRef(false); 
    const toggleGroup = (groupName) => {
        setOpenGroups((prev) => ({
          ...prev,
          [groupName]: !prev[groupName],
        }));
      }

      
    useEffect(() => {
      if (calledOnce.current) return; // 이미 호출된 경우 중복 호출 방지
      calledOnce.current =  true;

      chatBasixAxios.post("/getUserList")
        .then((response) => {
            console.log(response);
            const data = response.data;
            setUsersData(response.data);
            setMyProfile({comment: "나의 코멘트1",
                          dept: null,
                          id: null,
                          name: "김상우",
                          password: null,
                          position: "직책1",
                          profileImg: "https://i.pravatar.cc/40?img=50",
                          userId:"ksswy"});
        })
        .catch((error) => {
            console.error("사용자 목록을 가져오는 중 오류 발생: ", error);
        });
    }, []);

    return(
        <div className="chat-list">
            {myProfile && (
                <div className="user-item">
                    <div className="user-profile">
                        {myProfile.profileImg ? (
                        <img src={myProfile.profileImg} alt={myProfile.name} className="user-avatar" />
                        ) : (
                        <span className="default-icon">👤</span>
                        )}
                        <div className="user-info">
                        <div className="user-name-position">
                            <span className="user-name">{myProfile.name}</span>
                            <span className="user-position">{myProfile.position}</span>
                        </div>
                        <div className="user-comment">{myProfile.comment}</div>
                        </div>
                    </div>
                </div>
            )}
            {usersData.map((group) => (
                <div key={group._id} className="user-group">
                <div className="group-header" onClick={() => toggleGroup(group._id)}>
                    <span className="group-name">{group.deptName}</span>
                    <span className={`arrow ${openGroups[group._id] ? "open" : ""}`}>
                    ▼
                    </span>
                </div>
                {openGroups[group._id] && (
                    <ul className="user-items">
                    {group.memberList.map((user) => (
                        <li key={user.userId} className="user-item">
                        <div className="user-profile">
                            {user.profileImg ? (
                            <img src={user.profileImg} alt={user.name} className="user-avatar" />
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
