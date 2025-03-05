import { Client } from "@stomp/stompjs";
import SockJS from "sockjs-client";

const stompClient = new Client({
  webSocketFactory: () => new SockJS("http://localhost:8090/ws"), // ✅ SockJS WebSocket 연결
  reconnectDelay: 5000, // 자동 재연결 (5초)
  heartbeatIncoming: 4000, // 서버 → 클라이언트 하트비트
  heartbeatOutgoing: 4000, // 클라이언트 → 서버 하트비트
});

export default stompClient;