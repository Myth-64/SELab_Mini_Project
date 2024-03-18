import React from 'react';
import { IoMdClose } from 'react-icons/io';

const UserBadge = ({ content, handleFunction }) => {
  return (
    <>
      <p
        style={{
          backgroundColor: 'cyan',
          padding: '0.3rem 1.2rem 0.3rem 1.2rem',
          display: 'flex' /* to center the content inside red circle */,
          borderRadius: '10rem',
          justifyContent: 'center',
          alignContent: 'center',
          position: 'relative',
        }}
        onClick={handleFunction}
      >
        {content}
      </p>
      {/* <div
        className="exit-badge"
        style={{ position: 'absolute', left: '6.6rem', top: '4.7rem' }}
      >
        <IoMdClose />
      </div> */}
    </>
  );
};

export default UserBadge;
// transform: translate(-100%, -90%);
