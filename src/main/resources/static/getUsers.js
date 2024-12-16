async function getUsers() {

    const response = await fetch("api/admin/");

    if (response.ok) {
        let json = await response.json()
            .then(data => replaceTable(data));
    } else {
        alert("Ошибка HTTP: " + response.status);
    }

    const headerInfoJS = document.getElementById("headerInfo");

    const userInfo = data.email + " with roles: " + data.roles.map((role) => role.name === "ROLE_USER" ? " ROLE_USER " : " ROLE_ADMIN ");

    headerInfoJS.append(userInfo);

    function replaceTable(data) {

        const placement = document.getElementById("usersTablePlacement")
        placement.innerHTML = "";
        data.forEach(({id, username, email, password, authorities}) => {
            let userRoles = "";
            authorities.forEach((role) => {
                userRoles = userRoles + role.name + " ";
            });
            const element = document.createElement("tr");

            element.innerHTML = `
            <th scope="row">${id}</th>
            <td>${username}</td>
            <td>${email}</td>
            <td>${userRoles}</td>
            <td>
                <button type="button" class="btn btn-info text-white"
                    data-bs-userId=${id}
                    data-bs-userUsername=${username}
                    data-bs-userEmail=${email}
                    data-bs-userPassword = ${password}
                    data-bs-toggle="modal"
                    data-bs-target="#ModalEdit">Edit</button>
            </td>
            <td>
                <button type="button" class="btn btn-danger"
                    data-bs-userId=${id}
                    data-bs-userUsername=${username}
                    data-bs-userEmail=${email}
                    data-bs-toggle="modal"
                    data-bs-target="#ModalDelete">Delete</button>
            </td>
            `
            placement.append(element);
        })
    }
}
