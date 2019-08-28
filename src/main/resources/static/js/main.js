var auth = new Vue({
    el: '#auth',
    data: {
        login: "",
        password: "",
        logged: false,
        fullName: ""
    },
    methods: {
        sendAuthRequest: function() {
            console.log(getData());
            this.$http.post('/player/auth', getData()).then(response => {
                alert(response.body.fullName);
                this.logged = true;
                this.fullName = response.body.fullName;
                this.login = "";
                this.password = "";
            }, () => {
                alert("ERROR");
            });
        }
    }
});

function getData() {
    const authData = this.auth.$data;
    return {"login": authData.login, "password": authData.password}
}

function goToRegister() {
    const url = "register.html";
    window.location = url;
    window.open(url)
}