<template>
    <div>

        <form>

            <h1>Make an appointment</h1>
            <hr>
            <!--            <div v-if="errors.length > 0">-->
            <!--                <b>Please correct the following error(s):</b>-->
            <!--                <ul>-->
            <!--                    <li v-for="error in errors" v-bind:key="error">{{ error }}</li>-->
            <!--                </ul>-->
            <!--            </div>-->


            <ul class="wrapper">

                <li class="form-row">
                    <label><b>Date and time</b></label>

                    <input id="date-picker" name="date" required type="text" v-model="visit.date">

                </li>


                <li class="form-row">

                    <label><b>Clinic</b></label>
                    <select id="clinic-select" name="clinic" required v-model="visit.clinic">
                        <option selected value="Warszawa, Puławska 427">Warszawa, Puławska 427</option>
                        <option value="Gdynia, Morska 15">Gdynia, Morska 15</option>
                    </select>
                </li>

                <li class="form-row">

                    <label><b>Visit type</b></label>
                    <select id="visit-type-select" name="visitType" required v-model="visit.visitType">
                        <option value="pre-surgery">Pre-surgery</option>
                        <option value="post-surgery">Post-surgery</option>
                        <option value="check-up">Regular check-up</option>
                        <option value="emergency">Emergency</option>
                    </select>
                </li>

                <li class="form-row">

                    <label><b>Doctor</b></label>
                    <select id="doctor-select" name="doctor" required v-model="visit.doctor">
                        <option :key="doctor.id" :value="doctor" v-for="doctor in doctors">
                            {{doctor.firstName}}
                            {{doctor.lastName}}
                        </option>

                    </select>
                </li>

                <li class="form-row">

                    <label><b>Reason</b></label>
                    <textarea cols="50" rows="5" v-model="visit.reason"></textarea>
                </li>

                <li class="form-row">
                    <button @click.prevent="addNewVisit" class="signupbtn">Submit</button>
                    <!--                    <input type="submit" class="signupbtn" value="Submit" @click="addNewVisit"/>-->
                </li>
            </ul>
        </form>
    </div>

</template>

<script>
    /* eslint-disable */

    import {userId} from "@/repository";

    export default {
        name: "AppointmentForm",
        data() {
            return {
                errors: [],
                doctors: [],
                patients: [],
                visit: {
                    date: '',
                    description: '',
                    clinic: '',
                    visitType: '',
                    reason: '',
                    isPlanned: true

                },
                isSubmitted: false

            }
        },
        mounted() {
            this.getDoctors();
            this.getPatient();
        },
        methods: {


            checkForm() {


                this.errors = [];

                if (this.clinic == null)
                    this.errors.push('Please choose a clinic');
                if (this.visitType == null)
                    this.errors.push('Please choose visit type');
                if (this.doctor == null)
                    this.errors.push('Please choose a doctor');
                if (this.reason == null)
                    this.errors.push('Please state a reason.');

                this.validateDate();


                if (this.errors.length == 0)
                    this.addNewVisit();


            },

            validateDate() {

                let regEx = /^(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19|20)\d\d$/;

                if (!regEx.test(this.date)) {
                    this.errors.push('Date must be in DD/MM/YYYY format ')
                }

            },

            async addNewVisit() {

                this.checkForm();
                console.log(JSON.stringify(this.visit));

                try {
                    await fetch('http://localhost:5000/api/visits/', {
                        method: 'POST',
                        body: JSON.stringify(this.visit),
                        headers: {'Content-type': 'application/json; charset=UTF-8'},
                    })
                } catch (error) {
                    console.error(error)
                }


            },
            async getDoctors() {
                try {
                    const response = await fetch(
                        "http://localhost:5000/api/doctors"
                    );
                    const data = await response.json();
                    this.doctors = data;

                } catch (error) {
                    console.error(error);
                }


            }
            ,
            async getPatient() {
                try {
                    const response = await fetch(
                        `http://localhost:5000/api/patients/${userId}`
                    );
                    const data = await response.json();
                    this.visit.patient = data;
                } catch (error) {
                    console.error(error);
                }
            }
        }
    }
</script>

<style scoped>
    .wrapper .form-row {
        display: flex;
        justify-content: center;
        padding: 0.5rem;
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

    .wrapper {
        padding: 0;
    }

    button,
    .signupbtn {
        background-color: white;
        padding: 14px 28px;
        font-size: 16px;
        cursor: pointer;
        border: 2px solid #2196F3;
        color: dodgerblue;
        border-radius: 5px;
    }

    button:hover,
    .signupbtn:hover {
        background: #2196F3;
        color: white;
    }
</style>
