const addForm = document.getElementById("addForm");

const userAddUsername = document.getElementById("username");
const userAddEmail = document.getElementById("email");
const userAddPassword = document.getElementById("password");
const userAddRoles = document.getElementById("rolesId");

function getRolesArr(){

    let roles = Array.from(userAddRoles.selectedOptions)
        .map(option => option.value);
    let rolesToAdd = [];
    if (roles.includes("1 ROLE_ADMIN")) {
        let role1 = {
            id: 1,
            name: "ROLE_ADMIN"
        }
        rolesToAdd.push(role1);
    }
    if (roles.includes("2 ROLE_USER")) {
        let role2 = {
            id: 2,
            name: "ROLE_USER"
        }
        rolesToAdd.push(role2);
    }
    return rolesToAdd;
}

addForm.addEventListener("submit", (e) => {
    e.preventDefault();

    fetch("api/admin/", {
        method: "POST",
        headers: {
            "Content-type": "application/json",
        },
        body: JSON.stringify({
            username : userAddUsername.value,
            email : userAddEmail.value,
            password : userAddPassword.value,
            roles : getRolesArr()
        })
    })
        .then(() => getUsers())
        .then(() => addForm.reset());

    return show('users','newUser');
})