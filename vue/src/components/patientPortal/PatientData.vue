<template>
    <div>

        <h1>Your data</h1>
        <hr>

        <div v-if="fetched">
            <div :key="patient.id" v-for="patient in patients">
                <ul class="user-data-wrapper">

                    <li class="form-row">
                        <label><b>Name</b></label>
                        <p> {{patient.firstName}}</p>

                    </li>
                    <li class="form-row">
                        <label><b>Surname</b></label>
                        <p>{{patient.lastName}}</p>

                    </li>

                    <li class="form-row">
                        <label><b>Birthdate</b></label>
                        <p>{{patient.birthdate}}</p>

                    </li>

                    <li class="form-row">

                        <label><b>Sex</b></label>
                        <p>{{patient.sex}}</p>

                    </li>

                    <li class="form-row">

                        <label><b>PESEL</b></label>
                        <p>{{patient.pesel}}</p>

                    </li>


                    <li class="form-row">

                        <label><b>Email</b></label>
                        <p>{{patient.email}}</p>
                    </li>

                    <li class="form-row-btn">
                        <button class="change-password-button">Change password</button>
                        <button class="change-email-btn">Change email</button>

                    </li>


                </ul>
            </div>
        </div>
    </div>
</template>

<script>
    /* eslint-disable */

    import {userId} from "@/repository";

    export default {
        name: "PatientData",
        data() {
            return {
                patients: [],
                fetched: false
            }
        },
        mounted() {
            this.getPatient();
        },
        methods: {
            async getPatient() {
                try {
                    const response = await fetch(
                        `http://localhost:5000/api/patients/${userId}`
                    );
                    const data = await response.json();
                    this.patients = data;
                    this.fetched = true;
                } catch (error) {
                    // eslint-disable-next-line no-console
                    console.error(error);
                }
                // eslint-disable-next-line no-console
                console.log(this.patients.length);
            }
        }
    }
</script>

<style scoped>

    ul {
        list-style-type: none;

    }

    .user-data-wrapper .form-row {
        display: flex;
        justify-content: center;
        padding: 0.5rem;
    }

    .change-password-button,
    .change-email-btn {
        background-color: white;
        padding: 14px 28px;
        font-size: 16px;
        cursor: pointer;
        border: 2px solid #2196F3;
        color: dodgerblue;
        border-radius: 5px;
        margin-left: 3rem;

    }

    .change-password-button:hover,
    .change-email-btn:hover {
        background: #2196F3;
        color: white;
    }

    .user-data-wrapper .form-row p {
        flex: 2;
        font-size: 2rem;
    }

    .form-row label {
        flex: 1;
    }

    .form-row select, input, textarea {
        flex: 2;
    }

    .form-row label {
        font-size: 2rem;
        padding: 1rem;

    }
</style>
