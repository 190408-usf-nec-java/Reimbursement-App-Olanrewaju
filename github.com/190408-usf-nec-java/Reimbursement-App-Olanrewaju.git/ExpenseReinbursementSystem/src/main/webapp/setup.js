
let data = 10000;

const views = {
    loginView: document.getElementById('login-module'),
    signupView: document.getElementById('signup-module'),
    chatView: document.getElementById('chat-module')
}

const server = 'http://localhost:8080/ExpenseReinbursementSystem';

const transitionView = function(view) {
    const views = document.querySelectorAll('.module');
    const alerts = document.querySelectorAll('.alert');

    
    for(let i = 0; i < views.length; i++) {
        views[i].classList.remove('active-module');
    }
    for(let i = 0; i < alerts.length; i++) {
        alerts[i].innerText = '';
    }
    view.classList.add('active-module');

}
document.getElementById('signup-nav').addEventListener('click', () => {
    transitionView(views.signupView);
});

document.getElementById('login-nav').addEventListener('click', () => {
    transitionView(views.loginView);
});

const updateContent = function(payload) {
    data = JSON.parse(payload.srcElement.response);
    console.log(data);

    //const img = document.getElementById('chat-module');
    const reimb_data = document.getElementById('reinb');
    const reimb_data_1 = document.getElementById('reinb1');
    const reimb_data_2 = document.getElementById('reinb2');
    const reimb_data_3 = document.getElementById('reinb3');
    const reimb_data_4 = document.getElementById('reinb4');
    const reimb_data_5 = document.getElementById('reinb5');
    const reimb_data_6 = document.getElementById('reinb6');
    const reimb_data_7 = document.getElementById('reinb7');
    const reimb_data_8 = document.getElementById('reinb8');
   // const reimb_data9 = document.getElementById('reinb9');

   // img.src = data.sprites.front_default;
    
    reimb_data.innerText = 'FirstName: ' + data.reimb_firstname;
    reimb_data_1.innerText = 'LastName: ' + data.reimb_lastname;
    reimb_data_2.innerText = 'Reimbursement Amount: ' + data.reimb_amount;
    reimb_data_3.innerText = 'Reimbursement Submitted: ' + data.reimb_submitted;
    reimb_data_4.innerText = 'Reimbursement Resolved: ' + data.reimb_resolved;
    reimb_data_5.innerText = 'Reimbursement Description: ' + data.reimb_description;
    reimb_data_6.innerText = 'Reimbursement Type: ' + data.reimb_type;
    reimb_data_7.innerText = 'Reimbursement Status: ' + data.reimb_status;
    reimb_data_8.innerText = 'Reimbursement Receipt: ' + data.reimb_receipt;
   // reimb_data9.innerText = 'Reimbursement Amount: ' + data9.reimb_amount;
    
}

const updateContent_1 = function(payload) {
    data = JSON.parse(payload.srcElement.response);
    console.log(data);

    //const img = document.getElementById('chat-module');
    const reimb_data = document.getElementById('reinb');
    const reimb_data_1 = document.getElementById('reinb1');
    const reimb_data_2 = document.getElementById('reinb2');
    const reimb_data_3 = document.getElementById('reinb3');
    const reimb_data_4 = document.getElementById('reinb4');
    const reimb_data_5 = document.getElementById('reinb5');
    const reimb_data_6 = document.getElementById('reinb6');
    const reimb_data_7 = document.getElementById('reinb7');
    const reimb_data_8 = document.getElementById('reinb8');
    const reimb_data9 = document.getElementById('reinb9');

   // img.src = data.sprites.front_default;
    
    reimb_data.innerText = 'FirstName: ' + data.reimb_firstnameLink;
    reimb_data_1.innerText = 'LastName: ' + data.reimb_lastnameLink;
    reimb_data_2.innerText = 'Reimbursement Amount: ' + data.reimb_amount;
    reimb_data_3.innerText = 'Reimbursement Submitted: ' + data.reimb_submitted;
    reimb_data_4.innerText = 'Reimbursement Resolved: ' + data.reimb_resolved;
    reimb_data_5.innerText = 'Reimbursement Description: ' + data.reimb_description;
    reimb_data_6.innerText = 'Reimbursement Type: ' + data.reimb_type;
    reimb_data_7.innerText = 'Reimbursement Status: ' + data.reimb_status;
    reimb_data_8.innerText = 'Reimbursement Receipt: ' + data.reimb_receipt;
    reimb_data9.innerText = 'Reimbursement ID: ' + data.reimb_id;
    
}



const login = function(e) {
	e.stopPropagation();
    const username = document.getElementById('login-username');
    const password = document.getElementById('login-password');
    const alert = document.getElementById('login-alert');
    console.log("running");
    const payload = {
        username: username.value,
        password: password.value
    };

    const xhr = new XMLHttpRequest();
    xhr.open('post', `${server}/login`);
    
    xhr.addEventListener('load', updateContent);

    xhr.addEventListener('error', () => {
        alert.innerText = 'Something went wrong :(';
    });
    
    xhr.send(JSON.stringify(payload));
    const D = document.getElementById('reimb-request-module');
    D.style.display = 'block';
}


const signup = function() {
    const username_1 = document.getElementById('signup-username');
    const password_1 = document.getElementById('signup-password');
    const alert = document.getElementById('signup-alert');
    const payload = {
        username: username_1.value,
        password: password_1.value
    };

    const xhr = new XMLHttpRequest();
    xhr.open('post', `${server}/managerLogin`);
    
    xhr.addEventListener('load', updateContent_1);

    xhr.addEventListener('error', () => {
        alert.innerText = 'Something went wrong :(';
    });
    
    xhr.send(JSON.stringify(payload));
    const D = document.getElementById('resolve-module');
    D.style.display = 'block';
}


const enter_reimb = function(e) {
	e.stopPropagation();
    const type = document.getElementById('insert-type');
    const description = document.getElementById('insert-description');
    const amount = document.getElementById('insert-amount');
    
    const alert = document.getElementById('insert-alert');
    console.log("running");
    const payload = {
    		reimb_type_id: type.value,
    		reimb_description: description.value,
    		reimb_amount: amount.value,
    		reimb_author_id: data.reim_author
    };

    const xhr = new XMLHttpRequest();
    xhr.open('post', `${server}/enterReimbursement`);
    
   // xhr.addEventListener('load');

    xhr.addEventListener('error', () => {
        alert.innerText = 'Something went wrong :(';
    });
    
    xhr.send(JSON.stringify(payload));
    
}

const resolve = function(e) {
	e.stopPropagation();
    const reimb_status_id = document.getElementById('resolve');
    const reimb_id = document.getElementById('resolve-reimb-id');
   
    
    const alert = document.getElementById('resolve-alert');
    console.log("running");
    const payload = {
    		reimb_status_id: reimb_status_id.value,
    		reimb_id: reimb_id.value,
    		
    };

    const xhr = new XMLHttpRequest();
    xhr.open('post', `${server}/resolve`);
    
   // xhr.addEventListener('load');

    xhr.addEventListener('error', () => {
        alert.innerText = 'Something went wrong :(';
    });
    
    xhr.send(JSON.stringify(payload));
    
}


document.getElementById('login-submit').addEventListener('click', login);
document.getElementById('signup-submit').addEventListener('click', signup);
document.getElementById('insert-reimb-submit').addEventListener('click', enter_reimb);
document.getElementById('resolve-submit').addEventListener('click', resolve);