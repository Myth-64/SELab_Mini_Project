import React from 'react';
import '../assets/styles/UserListItem.css';

const UserListItem = ({ name, status, handleFunction }) => {
  return (
    <div className="modal-mainContents" onClick={handleFunction}>
      <h2 className="modal-title">{name}</h2>

      {/* <div className="modal-image text-center mt-lg-2">
            <img src={modalContent.image} alt="image" />
          </div> */}
      {/* <p className="mt-lg-3 modalText">{modalContent.content}</p> */}
    </div>
  );
};

export default UserListItem;
