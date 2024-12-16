const placement = document.getElementById("currentUser")
const headerInfoJS = document.getElementById("headerInfo")

let getCurrentUsers =()=> {


    fetch("http://localhost:8080/api/user/",
        {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(res => res.json())
        .then(user => {
            if (user != null) {
                const userInfo = user.email + " with roles: " + user.roles.map((role) => role.name === "ROLE_USER" ? " ROLE_USER " : " ROLE_ADMIN ");
                placement.innerHTML = `
                                <tr>
                                    <td> ${user.id} </td>
                                    <td> ${user.username} </td>
                                    <td> ${user.email} </td>
                                    <td> ${user.password} </td>
                                    <td> ${user.roles.map((role) => role.name === "ROLE_USER" ? " ROLE_USER " : " ROLE_ADMIN ")} </td>
                                </tr>
                        `
                headerInfoJS.append(userInfo);
            }
        })
}
    // const response = await fetch("api/user");
    //
    // if (response.ok) {
    //     let json = await response.json()
    //         .then(data => replaceTable(data));
    // } else {
    //     alert("Ошибка HTTP: " + response.status);
    // }
    //
    // function replaceTable(data) {
    //
    //
    //     placement.innerHTML = "";
    //     data.forEach(({id, username, email, authorities}) => {
    //         let userRoles = "";
    //         authorities.forEach((role) => {
    //             userRoles = userRoles + role.name + " ";
    //         });
    //         const element = document.createElement("tr");
    //
    //         element.innerHTML = `
    //         <th scope="row">${id}</th>
    //         <td>${username}</td>
    //         <td>${email}</td>
    //         <td>${userRoles}</td>
    //         `
    //         placement.append(element);
    //
    //     })
    // }
// }
getCurrentUsers();