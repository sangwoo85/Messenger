import React, { useState } from 'react';
import Messenger from './main/Messenger';
import Login from './main/Login';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (
    <Router>
      <Routes>
        <Route path="/login" element={ <Login/>} />
        <Route  path="/messenger" 
                element={ <Messenger />} />
        <Route path="/" element={<Navigate to="/login" />} />
      </Routes>
    </Router>
  )
}

//<Route path="/" element={<Login onLoginSuccess={() =>  setIsLoggedIn(true)} />} />
export default App;