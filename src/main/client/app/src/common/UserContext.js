import { createContext, useContext, useEffect, useState } from "react";
import api from "./ChatAxios"; // Axios 설정 파일

// 1️⃣ Context 생성
const UserContext = createContext();

// 2️⃣ Context Provider 컴포넌트
export function UserProvider({ children }) {
  const [userId, setUserId] = useState(null);

  useEffect(() => {
    // 서버에서 세션 정보 가져오기
    api.get("/auth/session")
      .then((response) => {
        console.log(response.data);
        setUserId(response.data.userId);
      })
      .catch((error) => {
        console.error("세션 정보 가져오기 실패:", error);
      });
  }, []);

  return (
    <UserContext.Provider value={{ userId, setUserId }}>
      {children}
    </UserContext.Provider>
  );
}

// 3️⃣ Context 사용을 쉽게 하기 위한 커스텀 훅
export function useUser() {
  return useContext(UserContext);
}