import React from 'react';

function MemoView({ memo }) {
  return (
    <div>
      <h2>{memo.name}</h2>
      <p>{memo.content}</p>
    </div>
  );
}

export default MemoView;
