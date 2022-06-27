let baseUrl = "http://localhost:8081"; //might have to change port



async function login(){

    //create object literal
    //document = DOM
    let uname = document.getElementById("uname").value;
    let pword = document.getElementById("pword").value;
    // console.log(uname);
    // console.log(pword);
    let user = {
        uname: uname,
        pword: pword
    }
    // console.log(user);
    
    // FETCH API CAN SEND REQUESTS TOO!
    // await fetch (url, {method : 'POST', mode : 'no idea', ...})
    
    //rememba: fetch returns promise
    
    let userJson = JSON.stringify(user); //turn it into a string that can be java'ed
    //console.log(userJson);
    
    let res = await fetch(
        `${baseUrl}/login`, 
        {
            method: 'PUT',
            header: {'Content-Type': 'application/json'},
            body: userJson
        }) //the {contains object}
        
        let resJson = await res.json() 
        //notice: no semicolon yet
        .then((resp)=>{
            
            console.log(resp);
            // currentUser = resp.name;
            sessionStorage.setItem('inUser', JSON.stringify(resp));

            window.location.assign("Employeehomepage.html");
            console.log(currentUser);



            //session storage here
            
        }) 
        //^ where we will put needed DOM manip
        
        
        .catch((error)=>{console.log(error);});
        
    }

   function ChangeName(){
       // let newName = currentUser;
        let namea = document.getElementById("name");
        let foundUser = JSON.parse(sessionStorage.getItem('inUser'));
        namea.innerText = (`Hello ${foundUser.name}!`);

        // console.log(foundUser.e_id);

        PopulateTable();


    }

    async function PopulateTable(){
        let foundUser = (sessionStorage.getItem('inUser')); //no prase here, we need to pass string to java
        // console.log(foundUser.uname);
        let res = await fetch(`
                    ${baseUrl}/requests`,
                    {
                        method: 'GET',
                        header: {'Content-Type': 'application/json'},
                        body: foundUser

                    }
        );
                let resJson = await res.json()

                .then((resp) =>{
                    console.log(resp);
                    // let test = JSON.stringify(resp);
                    // console.log(test); not needed, already an object

                    var table = document.getElementById("TheTable");
                    
                    for (const entry of resp){
                    
                    var row = table.insertRow(-1);

                    var cell1 = row.insertCell(0);
                    var cell2 = row.insertCell(1);
                    var cell3 = row.insertCell(2);
                    var cell4 = row.insertCell(3);
                    var cell5 = row.insertCell(4);
                    var cell6 = row.insertCell(5);
                    var cell7 = row.insertCell(6);
                    var cell8 = row.insertCell(7);
                    var cell9 = row.insertCell(8);
                    var cell10 = row. insertCell(9);
                    var cell11 = row.insertCell(10);
                    var cell12 = row.insertCell(11);


                //     id</th>
                //     Requester</th>
                //     Manager</th>
                //     done?</th>
                //     grade</th>
                //     type</th>
                //     passing grade</th>
                //     date & time of event</th>
                //     location</th>
                //     description</th>
                //     justification</th>


                    cell1.innerText = entry.req_id;
                    cell2.innerText = entry.requester;
                    cell3.innerText = entry.manager;
                    cell4.innerText = entry.is_done;
                    cell5.innerText = entry.grade;
                    cell6.innerText = entry.grading_scheme
                    cell7.innerText = entry.cost;
                    cell8.innerText = entry.passing_grade;
                    cell9.innerText = new Date(entry.datetime);
                    cell10.innerText = entry.location;
                    cell11.innerText = entry.description;
                    cell12.innerText = entry.justification;
                
                
                
                 }

                })
                .catch((error) => {
                    console.log(error);
                });
    
    }