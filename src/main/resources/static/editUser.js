const editModal = document.getElementById('ModalEdit')
editModal.addEventListener('show.bs.modal', event => {

    const button = event.relatedTarget
    // console.log(button)

    const userId = button.getAttribute('data-bs-userId')
    const userUserName = button.getAttribute('data-bs-userUserName')
    const userEmail = button.getAttribute('data-bs-userEmail')
    const userPassword = button.getAttribute('data-bs-userPassword')

    const modalUserId = editModal.querySelector('#userId')
    const modalUserUserName = editModal.querySelector('#userUserName')
    const modalUserEmail = editModal.querySelector('#userEmail')
    const modalUserPassword = editModal.querySelector('#userPassword')

    modalUserId.value = userId
    modalUserUserName.value = userUserName
    modalUserEmail.value = userEmail
    modalUserPassword.value = userPassword

})

const formEdit = document.getElementById("formEdit");
formEdit.addEventListener('submit', e => {
    e.preventDefault();

    const formData = new FormData(formEdit);
    const object = {
        roles:[]
    };

    formData.forEach((value, key) => {
        console.log(key)
        if (key === "rolesId"){

            const roleId = value.split(" ")[0];
            const roleName = value.split(" ")[1];
            const authorities = {
                id : roleId,
                name : roleName
            };

            object.roles.push(authorities);
        } else {
            object[key] = value;
        }
    });
    fetch("api/admin/", {
        method: "PUT",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(object)
    })
        .then(() => getUsers());
    $("#ModalEdit").modal("hide");
    formEdit.reset();
})