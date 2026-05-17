import React, { useEffect, useState } from 'react';

function App() {
  const [msg, setMsg] = useState('');
  useEffect(() => {
    fetch('/api/hello')
      .then(res => res.text())
      .then(setMsg);
  }, []);
  return (
    <div>
      <h1>Java 3-Tier App Frontend</h1>
      <p>Backend says: {msg}</p>
    </div>
  );
}

export default App;
