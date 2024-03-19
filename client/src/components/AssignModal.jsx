import React, { useState } from 'react';
import { IoMdClose } from 'react-icons/io';
import '../assets/styles/AssignModal.css';
import UserBadge from './UserBadge';
import { toast } from 'react-toastify';
import UserListItem from './UserListItem';

const AssignModal = ({
  isModalOpen,
  modalContent,
  onClose,
  setModalContent,
}) => {
  if (isModalOpen !== true) {
    return null;
  }
  const [selectedUsers, setSelectedUsers] = useState([]);

  const handleGroup = (userToAdd) => {
    console.log('handleGroup');
    if (selectedUsers.includes(userToAdd)) {
      // toast({
      //   title: 'User already added',
      //   status: 'warning',
      //   duration: 5000,
      //   isClosable: true,
      //   position: 'top',
      // });
      toast.warning('User already addded');

      return;
    }

    setSelectedUsers([...selectedUsers, userToAdd]);
    setModalContent(modalContent.filter((x) => !selectedUsers.includes(x)));
    console.log(modalContent);
  };
  const handleDelete = (delUser) => {
    console.log('handleDelete');
    setSelectedUsers(selectedUsers.filter((sel) => sel !== delUser));
  };
  //handle submit button that will post reviewer list after selection,onclick closes modal too

  return (
    <section className="modal">
      <div className="modal-content p-lg-4">
        <h2>Reviewer List</h2>
        <div className="exit-icon">
          <IoMdClose onClick={onClose} />
        </div>
        <div className="selected">
          {selectedUsers.map((u, index) => (
            <UserBadge
              key={index}
              content={u}
              handleFunction={() => handleDelete(u)}
            />
          ))}
        </div>
        {modalContent.map((content, index) => {
          const { name, status } = content;
          return (
            <UserListItem
              key={index}
              name={name}
              handleFunction={() => handleGroup(name)}
            />
          );
        })}
        <button className="modal-button">Submit </button>
      </div>
    </section>
  );
};

export default AssignModal;
