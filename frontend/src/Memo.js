import React, { useState, useEffect} from 'react';
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
      {showContent ? memo.text : 'from. ' + memo.author}
    </div>
  );
}

export default Memo;
