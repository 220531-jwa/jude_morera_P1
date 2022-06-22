let baseUrl = "http://localhost:8081"; //might have to change port
function login(){
    console.log("YEAAH BABY WOO HOO THAT'S WHAT LIKE TO SEE!!!")

    //needs to take the inputs

    //create object literal
//document = DOM
    let uname = document.getElementById("uname").value;
    let pword = document.getElementById("pword").value;
    // console.log(uname);
    // console.log(pword);
    let user = {
        username: uname,
        password: pword
    }
    console.log(user);

    // FETCH API CAN SEND REQUESTS TOO!
    // await fetch (url, {method : 'POST', mode : 'no idea', ...})

    //rememba: fetch returns promise

    let userJson = JSON.stringify(user); //turn it into a string that can be java'ed
    console.log(userJson);

    let res = await fetch(`${baseUrl}/login`, 
    {
        method: 'POST',
        header: {'Content-Type': 'application/json'},
        body: userJson
    }); //the {contains object}

    let resJson = await res.json()//awaiting for promised returned user (from db) 
                                    //notice: no semicolon yet
    .then((resp)=>{console.log(resp);
        // window.location.assign("homepage.html");
    }) //executes if successful; both take function for argument
    //^ where we will put needed DOM manip
    

    .catch((error)=>{console.log(error);}); //executes if not

}