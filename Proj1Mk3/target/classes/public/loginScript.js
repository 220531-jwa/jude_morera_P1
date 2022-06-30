let baseUrl = "http://localhost:8081"; //might have to change port



async function login(){
    
    //create object literal
    //document = DOM
    let uname = document.getElementById("uname").value;
    let pword = document.getElementById("pword").value;
    let mana = document.getElementById("managerCheckBox").checked;
    
    
    if (!mana){
        
        let user = {
            uname: uname,
            pword: pword,
            // fin_man: mana
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
            }); //the {contains object}
            
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
            
        }//end of non-manager
        else{
            let user = {
                uname: uname,
                pword: pword,
                fin_man: mana
            }
            
            
            let userJson = JSON.stringify(user); 
            
            let res = await fetch(
                `${baseUrl}/login/manager`, 
                {
                    method: 'PUT',
                    header: {'Content-Type': 'application/json'},
                    body: userJson
                }); 
                
                let resJson = await res.json() 
                
                .then((resp)=>{
                    
                    console.log(resp);
                    
                    sessionStorage.setItem('inUser', JSON.stringify(resp));
                    
                    window.location.assign("Managerhomepage.html");
                    console.log(currentUser);
                    
                    
                    
                    
                    
                }) 
                //^ where we will put needed DOM manip
                
                
                .catch((error)=>{console.log(error);});
                
            }
        }
        
        
        
        
        
        async function sendRequest(){
            //variable finders
            // let e_id = document.getElementById("e_id").value;
            // let name = document.getElementById("name").value;
            
            
            let typeSelect = document.getElementById("type")
            let type = typeSelect.options[typeSelect.selectedIndex].value;
            
            let cost = document.getElementById("cost").value;
            let passing_grade =(document.getElementById("passing_grade").value/100);
            
            let datetime = document.getElementById("datetime").value
            
            let location = document.getElementById("location").value;
            let description = document.getElementById("description").value;
            let justification = document.getElementById("justification").value;
            
            // console.log(`${type}, ${cost}, ${passing_grade}, ${datetime}, ${location}, ${description}, ${justification}`);
            
            let foundUser = JSON.parse(sessionStorage.getItem('inUser'));
            
            let req = {
                requester: foundUser.e_id, //remember, this is int id
                grading_scheme : type,
                cost : cost,
                passing_grade : passing_grade,
                datetime : datetime,
                location : location,
                description : description,
                justification : justification
                
            };
            console.log(req);
            let reqJSON = JSON.stringify(req);
            console.log(reqJSON)
            let res = await fetch(
                `${baseUrl}/newRequest`, 
                {
                    method: 'POST',
                    header: {'Content-Type': 'application/json'},
                    body: reqJSON
                });
                
                let resJson = await res.json()
                .then((resp)=>{
                    console.log("made it to then");
                    if (res.status === 200){
                        // console.log(resp);
                        // console.log("SHUTUP");
                        
                        
                        
                        
                    }
                }) 
                //^ where we will put needed DOM manip
                
                
                .catch((error)=>{console.log(error);
                    
                });
                
                
                
                //document.getElementById("form").reset();
            }//end func
            
            function ChangeName(){
                let namea = document.getElementById("name");
                let foundUser = JSON.parse(sessionStorage.getItem('inUser'));
                namea.innerText = (`Hello ${foundUser.name}!`);
            }
            
            
            function ChangeNameFront(){
                // let newName = currentUser;
                let namea = document.getElementById("name");
                let foundUser = JSON.parse(sessionStorage.getItem('inUser'));
                namea.innerText = (`Hello ${foundUser.name}!`);
                
                // console.log(foundUser.e_id);
                
                PopulateTable();
                
                
            }
            
            
            
            async function PopulateTable(){
                let foundUser = (sessionStorage.getItem('inUser')); 
                
                let res = await fetch(`
                ${baseUrl}/requests`,
                {
                    method: 'POST',
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
                    var selector = document.getElementById('idSelector');
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
                        
                        //     grade</th>
                        //     type</th>
                        //     passing grade</th>
                        //     date & time of event</th>
                        //     location</th>
                        //     description</th>
                        //     justification</th>
                        //     status
                        
                        
                        cell1.innerText = entry.req_id;
                        cell2.innerText = entry.requester;
                        // cell3.innerText = entry.manager;
                        // cell4.innerText = entry.is_done;
                        cell3.innerText = entry.grade;
                        cell4.innerText = SetType(entry.grading_scheme);
                        cell5.innerText = entry.cost;
                        cell6.innerText = entry.passing_grade;
                        cell7.innerText = new Date(entry.datetime);
                        //let reimbSubmitted = new Date().toISOString().slice(0, 10);
                        
                        cell8.innerText = entry.location;
                        cell9.innerText = entry.description;
                        cell10.innerText = entry.justification;
                        cell11.innerText = entry.status;
                        
                        if (entry.status == 1){
                            let newB = document.createElement('option');
                            newB.setAttribute("value",entry.req_id);
                            newB.innerText = entry.req_id;
                            selector.appendChild(newB);
                        }
                        
                        
                    }
                    
                })
                .catch((error) => {
                    console.log(error);
                });
                
            }
            
            async function PopulateTableManagerial(){
                let foundUser = (sessionStorage.getItem('inUser')); 
                
                let res = await fetch(`
                ${baseUrl}/requests/manager`,
                {
                    method: 'POST',
                    header: {'Content-Type': 'application/json'},
                    body: foundUser
                    
                }
                );
                let resJson = await res.json()
                
                .then((resp) =>{
                    console.log(resp);
                    // let test = JSON.stringify(resp);
                    // console.log(test); not needed, already an object
                    
                    var table = document.getElementById("TheManagerTable");
                    var selector = document.getElementById('idSelector');
                    
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
                        // var cell12 = row.insertCell(11);
                        
                        
                        //     id</th>
                        //     Requester</th>
                        
                        //     grade</th>
                        //     type</th>
                        //     passing grade</th>
                        //     date & time of event</th>
                        //     location</th>
                        //     description</th>
                        //     justification</th>
                        //     status
                        
                        
                        cell1.innerText = entry.req_id;
                        cell2.innerText = entry.requester;
                        // cell3.innerText = entry.manager;
                        // cell4.innerText = entry.is_done;
                        cell3.innerText = entry.grade;
                        cell4.innerText = SetType(entry.grading_scheme);
                        
                        
                        
                        cell5.innerText = entry.cost;
                        cell6.innerText = entry.passing_grade;
                        cell7.innerText = new Date(entry.datetime);
                        //let reimbSubmitted = new Date().toISOString().slice(0, 10);
                        
                        cell8.innerText = entry.location;
                        cell9.innerText = entry.description;
                        cell10.innerText = entry.justification;
                        cell11.innerText = entry.status;
                        
                        
                            let newB = document.createElement('option');
                            newB.setAttribute("value",entry.req_id);
                            newB.innerText = entry.req_id;
                            selector.appendChild(newB);
                        
                        
                    }
                    
                })
                .catch((error) => {
                    console.log(error);
                });
            }  
            
            function SetType(num){
                let word = 'other';
                switch (num){
                    case 0: word = 'invalid';
                    break;
                    case 1: word = 'University Course';
                    break;
                    case 2: word = 'Seminar';
                    break;
                    case 3: word = 'Certification Prep. Class';
                    break;
                    case 4: word = 'Certification';
                    break;
                    case 5: word = 'Technical Training';
                    break;
                    default: break;
                }
                return word;
            }
            
            function ChangeNameMan(){
                
                let namea = document.getElementById("name");
                let foundUser = JSON.parse(sessionStorage.getItem('inUser'));
                namea.innerText = (`Hello ${foundUser.name}!`);
                
                PopulateTableManagerial();
            }
            
            
            function logout(){
                sessionStorage.clear();
            }
            
            
            
            async function ChangeGrade(){
                
                let selector = document.getElementById('idSelector');
                let grador = document.getElementById('newGrade');
                
                let idChanged = selector.options[selector.selectedIndex].value;
                let gradeChanged = (grador.value/100); 
                
                let grad = {
                    req_id :idChanged,
                    grade: gradeChanged
                }

                let gradString = JSON.stringify(grad);
                console.log(gradString);
                
                
                
                let res = await fetch(`
                ${baseUrl}/requests`,
                {
                    method: 'PATCH',
                    header: {'Content-Type': 'application/json'},
                    body: gradString
                    
                }
                );
                let resJson = await res.json()
                
                .then(()=>{
                    
                    console.log("nice");
                    
                }) 
                .catch((error) => {
                    console.log(error);
                });
            }
            async function ChangeStatus(){
                
                let selector = document.getElementById('idSelector');
                let statusa = document.getElementById('newStatus');
                
                let idChanged = selector.options[selector.selectedIndex].value;
                let statusChanged = (statusa.value); 
                
                let stat = {
                    req_id :idChanged,
                    status: statusChanged
                }

                let statString = JSON.stringify(stat);
                console.log(statString);
                
                
                
                let res = await fetch(`
                ${baseUrl}/requests/manager`,
                {
                    method: 'PATCH',
                    header: {'Content-Type': 'application/json'},
                    body: statString
                    
                }
                );
                let resJson = await res.json()
                
                .then(()=>{
                    
                    console.log("nice");
                    
                }) 
                .catch((error) => {
                    console.log(error);
                });
            }