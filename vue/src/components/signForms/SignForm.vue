<template>
    <div>
        <div class="form-wrapper">
            <div class="sign-content">
                <div>

                    <ul class="register-tabs">
                        <li class="tab active">
                            <button @click="isLogIsToggled = false">Sign Up</button>
                        </li>
                        <li class="tab">
                            <button @click="isLogIsToggled = true">Log In</button>
                        </li>
                    </ul>


                    <div class="sign-up-wrapper" v-if="!isLogIsToggled">

                        <form @submit="addNewPatient" action="/" method="POST" novalidate="true">

                            <label><b>First Name</b></label>
                            <input name="first-name" type="text" v-model="patient.firstName">


                            <label><b>Last Name</b></label>
                            <input name="last-name" type="text" v-model="patient.lastName">


                            <label><b>Email</b></label>
                            <input name="email" type="text" v-model="patient.email">


                            <label><b>Phone number</b></label>
                            <input name="phone-number" type="text" v-model="patient.phoneNumber">


                            <label><b>Birth date</b></label>
                            <input name="birth-date" type="text" v-model="patient.birthdate">


                            <label><b>PESEL</b></label>
                            <input name="pesel" type="text" v-model="patient.PESEL">


                            <div class="clearfix">
                                <button @click="addNewPatient" class="signupbtn" type="button">Submit</button>
                                <!--                                <button @click="$emit('close')" class="signupbtn" type="button">Submit</button>-->
                            </div>
                        </form>
                    </div>


                    <div class="log-in-wrapper" v-if="isLogIsToggled">

                        <form action="/" method="POST">


                            <label><b>Email</b></label>
                            <input id="email" name="email" type="text">


                            <label><b>Password</b></label>
                            <input name="password" type="text">


                            <div class="clearfix">
                                <!--                        <button  type="button" class="cancelbtn"><a href="index.html">Cancel </a></button>-->
                                <!--                        <button type="submit" class="signupbtn"> <a href="patient-main.html">Sign Up </a> </button>-->
                                <button @click="$emit('close')" class="signupbtn" type="button">Submit</button>
                            </div>
                        </form>
                    </div>


                </div>


            </div>
        </div>
    </div>
</template>

<script>
    /* eslint-disable */

    export default {
        name: "signForm",
        data() {
            return {
                isLogIsToggled: false,
                errors: [],
                patient: {
                    firstName: '',
                    lastName: '',
                    PESEL: '',
                    email: '',
                    birthdate: '',
                    phoneNumber: '',
                }

            }
        },
        methods: {
            async addNewPatient() {
                try {

                    console.log(this.patient);
                    const response = await fetch('http://localhost:5000/api/patients/', {
                        method: 'POST',
                        body: JSON.stringify(this.patient),
                        headers: {'Content-type': 'application/json; charset=UTF-8'},
                    });
                    const data = await response.json();
                    this.patient = data;
                    console.log(this.patient);
                } catch (error) {
                    console.error(error)
                }
                this.$emit('close');
                alert('form submitted');
            },
        }
    }
</script>

<style scoped>


    .form-wrapper {
        position: fixed;
        z-index: 1; /* Sit on top */
        padding-top: 100px; /* Location of the box */
        left: 0;
        top: 0;
        width: 100%; /* Full width */
        height: 100%; /* Full height */
        overflow: auto; /* Enable scroll if needed */
        background-color: rgb(0, 0, 0); /* Fallback color */
        background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
    }


    .sign-content {
        display: flex;
        background: #713E5A;
        padding: 2rem;
        max-width: 600px;
        margin: 0px;
        border-radius: 10px;
        color: white;
        margin: auto;


    }

    .sign-content h1 {
        margin-top: 20px;
        text-align: center;
    }

    .sign-content input[type=text],
    input[type=password] {
        width: 100%;
        padding: 15px;
        margin: 5px 0 22px 0;
        display: inline-block;
        border: none;
        background: #dddddd;
        color: black;
    }

    .sign-content input[type=text]:focus,
    input[type=password]:focus {
        background-color: #ddd;
        outline: none;
        color: black;
    }

    .sign-content button {
        background-color: #339999;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
        opacity: 0.9;
        font-size: 2em;
        z-index: 3;
    }

    .sign-content button:hover {
        opacity: 1;
    }

    .sign-content .error-summary {
        color: red;
        font-family: "Bell MT";
    }

    .cancelbtn,
    .signupbtn {
        float: left;
        width: 50%;
        display: block;
    }

    .register-tabs {
        list-style: none;
        padding: 10px;
        display: block;
        z-index: 2;
        position: relative;

    }

    .register-tabs li button {
        text-decoration: none;
        padding: 20px;
        background: #9bafa7;
        color: white;
        font-size: 20px;
        float: left;
        width: 50%;
        text-align: center;
        cursor: pointer;
        transition: .5s ease;
        margin-bottom: 20px;


    }

    .register-tabs li button:hover {
        background: #713e5a;
        color: white;
    }

    .register-tabs li button.active button {
        background: #713e5a;
        color: white;
    }

    .sign-content {
        display: flex;
    }


    @media all and (max-width: 900px) {
        .form-wrapper {
            position: relative;
            z-index: 1; /* Sit on top */
            padding-top: 0px; /* Location of the box */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: hidden; /* Enable scroll if needed */
            background-color: rgba(0, 0, 0, 0); /* Black w/ opacity */

        }


        .sign-content {
            display: flex;
            background: #713E5A;
            padding: 2rem;
            max-width: none;
            margin: 0px;
            border-radius: 0px;
            color: white;
            margin: auto;


        }


    }

</style>
