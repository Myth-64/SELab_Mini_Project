import React, { useEffect, useState } from 'react';
import { IoMdClose } from 'react-icons/io';
import '../assets/styles/AssignModal.css';
import UserBadge from './UserBadge';
import { toast } from 'react-toastify';
import UserListItem from './UserListItem';
import axios from 'axios';

const CheckModal = ({
  isModalOpen,
  modalContent,
  onClose,
  setModalContent,
}) => {
  if (isModalOpen !== true) {
    return null;
  }

  // use a get request to get modal content
  return (
    <section className="modal">
      <div className="modal-content p-lg-4">
        <h2>Reviewer List</h2>
        <div className="exit-icon">
          <IoMdClose onClick={onClose} />
        </div>
        {modalContent.map((content, index) => {
          const { name, status, id } = content;
          return (
            <UserListItem
              key={index}
              name={name}
              id={id}
              handleFunction={() => handleGroup(name, id)}
            />
          );
        })}
      </div>
    </section>
  );
};

export default CheckModal;
