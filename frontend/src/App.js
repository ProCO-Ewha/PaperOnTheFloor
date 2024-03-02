import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Memo from './Memo';
import './App.css';

function App() {
  const [memos, setMemos] = useState([]);
  const [showForm, setShowForm] = useState(false);
  const [newMemo, setNewMemo] = useState({name: '', content: '',});

  useEffect(() => {
    axios.get('http://localhost:8080/home')
      .then(response => {
        setMemos(response.data);
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

  /*const handleSubmit = (e) => {
    e.preventDefault();
    const nextId = memos[memos.length - 1].id + 1;
    setShowForm(false);
  };*/

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post('http://localhost:8080/papers/new', newMemo)
      .then(response => {
        setNewMemo({name: '', content: ''});
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
              <textarea type="text" name="name" placeholder="Name" onChange={handleInputChange} />
              <textarea type="text" name="content" placeholder="Write here" onChange={handleInputChange} />
              <button type="submit">Submit</button>
            </form>
          )}
        </div>
      );
          
}

export default App;