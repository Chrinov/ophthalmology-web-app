<template>
    <div>
        <div class="nav-menu">

            <ul>

                <li class="home">
                    <router-link to="/"><i class="glyphicon glyphicon-home"></i></router-link>
                </li>
                <li><a href="#">Contact</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Clinics</a></li>
                <li>
                    <router-link to="/specialists">Doctors</router-link>
                </li>
                <li><a href="#">Price list</a></li>
                <li>
                    <router-link to="/patientportal">Patient Portal</router-link>
                </li>

                <!--                <li class="appointment-button"><a @click="$emit('showForm = true')">Make an appointment</a ></li>-->


            </ul>

        </div>
    </div>
</template>

<script>
    export default {
        name: "Navbar",
        methods: {
            showSignUpForm() {

            }
        }
    }
</script>

<style scoped>

    .nav-menu a {
        color: white;
        text-decoration: none;
        padding: 20px 10px;
        background-color: #339999;
        display: inline-block;
        width: 100%;
        text-align: center;
        overflow: hidden;
        font-family: "Segoe UI";
        font-size: 3rem;
    }

    .nav-menu a:hover {
        background-color: #723f5b;
    }

    .nav-menu ul {
        list-style: none;
        margin: 0;
        padding: 0;
        display: flex;
        white-space: nowrap;
        overflow: hidden;
    }

    .nav-menu li {
        flex: 3;
    }

    .nav-menu .home {
        flex: 2;
    }

    .nav-menu .appointment-button {
        display: none;
        background-color: #73415D;
    }


    @media all and (max-width: 900px) {
        .nav-menu ul {
            flex-wrap: wrap;
        }

        .nav-menu li {
            flex-basis: 100%;
        }

        .nav-menu .appointment-button {
            display: inline-flex;
        }

        .nav-menu .appointment-button a {
            background-color: #6078ea;
        }
    }
</style>
