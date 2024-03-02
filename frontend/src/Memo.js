import React, { useState, useEffect} from 'react';
import MemoView from './MemoView';
import './Memo.css';

const colors = ['yellow', 'skyblue', 'pink', 'lightgreen'];


function Memo({ memo }) {
  const [showContent, setShowContent] = useState(false);
  const [color, setColor] = useState('');

  useEffect(() => {
    setColor(colors[Math.floor(Math.random() * colors.length)]);
  }, []);

  const handleClick = () => {
    setShowContent(!showContent);
  };

  return (
    <div className="memo" onClick={handleClick} style={{backgroundColor: color}}>
      {showContent ? memo.content : memo.name}
    </div>
  );
}

export default Memo;