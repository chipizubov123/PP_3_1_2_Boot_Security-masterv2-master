const DeleteModal = document.getElementById('ModalDelete')
DeleteModal.addEventListener('show.bs.modal', event => {

    const button = event.relatedTarget

    console.log(button)
    const userId = button.getAttribute('data-bs-userId')
    const userUsername = button.getAttribute('data-bs-userUsername')
    const userEmail = button.getAttribute('data-bs-userEmail')
    console.log(button)

    const modalUserId = DeleteModal.querySelector('#userIdDelete')
    const modalUserUsername = DeleteModal.querySelector('#userUsernameDelete')
    const modalUserEmail = DeleteModal.querySelector('#userEmailDelete')

    modalUserId.value = userId
    modalUserUsername.value = userUsername
    modalUserEmail.value = userEmail

})

const formDelete = document.getElementById('formDelete')
formDelete.addEventListener('submit', e =>{
    e.preventDefault();
    const formData = new FormData(formDelete);
    fetch("api/admin/"+formData.get("id"), {
        method: "DELETE"
    })
        .then(() => getUsers());
    $("#ModalDelete").modal("hide");
    formDelete.reset();
})