import React, { useState } from 'react';
import Messenger from './main/Messenger';
import Login from './main/Login';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return isLoggedIn ? <Messenger /> : <Login onLoginSuccess={() =>  setIsLoggedIn(true)} />;
}

export default App;