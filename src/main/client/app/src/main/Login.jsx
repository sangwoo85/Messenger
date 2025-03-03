import React, { useState } from 'react';
import './Login.css';
import chatBasixAxios from '../common/ChatAxios';
import { useNavigate } from "react-router-dom";


export default function Login({ onLoginSuccess }) {
  const [formData, setFormData] = useState({
    userId: '',
    password: '',
    autoLogin: false
  });
  const navigate = useNavigate();
  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: type === 'checkbox' ? checked : value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // TODO: 로그인 로직 구현
    console.log('로그인 시도:', formData);

    chatBasixAxios.post('/login', {"userId":formData.userId,"password":formData.password}
        ).then(response => {
            //onLoginSuccess();
            navigate("/messenger");
    }).catch(error => {
        console.log(error);
    });
    

  };

  return (
    <div className="login-container">
      <div className="login-box">
        <h1 className="login-title">Messenger</h1>
        <form onSubmit={handleSubmit} className="login-form">
          <div className="input-group">
            <input
              type="text"
              name="userId"
              value={formData.userId}
              onChange={handleChange}
              placeholder="아이디"
              className="login-input"
            />
          </div>
          <div className="input-group">
            <input
              type="password"
              name="password"
              value={formData.password}
              onChange={handleChange}
              placeholder="비밀번호"
              className="login-input"
            />
          </div>
          <div className="auto-login-group">
            <label className="auto-login-label">
              <input
                type="checkbox"
                name="autoLogin"
                checked={formData.autoLogin}
                onChange={handleChange}
                className="auto-login-checkbox"
              />
              <span>자동 로그인</span>
            </label>
          </div>
          <button type="submit" className="login-button">로그인</button>
          <div className="find-password">
            <button type="button" className="find-password-button">
              비밀번호 찾기
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}
