import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Memo from './Memo';
import './App.css';

function App() {
  const [memos, setMemos] = useState([]);
  const [showForm, setShowForm] = useState(false);
  const [newMemo, setNewMemo] = useState({author: '', text: '',});

  
  useEffect(() => {
    axios.get('/home')
      .then(response => {
        // 서버로부터 받은 JSON 데이터를 배열로 변환하여 설정
        setMemos(Array.isArray(response.data) ? response.data : [response.data]);
      })
      .catch(error => {
        console.error('There was an error!', error);
      });
}, []);

  

  const handleAddClick = () => {
    setShowForm(!showForm);
  };

  const handleInputChange = (e) => {
    setNewMemo({...newMemo, [e.target.name]: e.target.value});
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post('/papers/new', newMemo)
      .then(response => {
        setNewMemo({author: '', text: ''});
        setShowForm(false);
      })
      .catch(error => {
        console.error('There was an error!', error);
      });
    }

      return (
        <div className="App">
          <div id="logo-text">Paper On The Floor</div>
          <div className="memo-container">
            {memos.map(memo => (
              <Memo key={memo.id} memo={memo} />
            ))}
          </div>
          <button className="button-adddiary" onClick={handleAddClick}>+</button>
          {showForm && (
            <form className="memo-form" onSubmit={handleSubmit}>
            <textarea type="text" name="author" placeholder="Name" onChange={handleInputChange} />
            <textarea type="text" name="text" placeholder="Write here" onChange={handleInputChange} />
            <button type="submit">Submit</button>
          </form>
          
          )}
        </div>
      );
          
}

export default App;