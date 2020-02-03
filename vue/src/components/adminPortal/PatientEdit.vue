<template>
    <div>
        <div class="modal" style="display: inline">

            <!-- Modal content -->
            <div class="modal-content">
                <div class="modal-body">


                    <div style="overflow-x:auto;">
                        <table v-if="isDataLoaded">
                            <tr>
                                <td>PESEL</td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="text" v-model="updatedPatient.pesel">
                                </td>
                            </tr>
                            <tr>
                                <td>First name</td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="text" v-model="updatedPatient.firstName">

                                </td>
                            </tr>
                            <tr>
                                <td>Last Name</td>
                            </tr>

                            <tr>
                                <td>
                                    <input type="text" v-model="updatedPatient.lastName">

                                </td>
                            </tr>

                            <tr>
                                <td>Email</td>
                            </tr>

                            <tr>
                                <td>
                                    <input type="text" v-model="updatedPatient.email">

                                </td>
                            </tr>

                            <tr>
                                <td>Phone number</td>
                            </tr>

                            <tr>
                                <td>
                                    <input type="text" v-model="updatedPatient.phoneNumber">

                                </td>
                            </tr>


                        </table>
                    </div>


                    <div class="button-row">
                        <button @click="editPatient(updatedPatient.id)">SAVE</button>
                        <button @click="$emit('close')">CANCEL</button>
                        <button @click="deletePatient(updatedPatient.id)">DELETE PATIENT</button>
                    </div>

                </div>
            </div>

        </div>

    </div>
</template>

<script>
    /* eslint-disable */

    export default {
        name: "PatientEdit",
        data() {
            return {
                specialists: [],
                isDataLoaded: false,
                updatedPatient: Object

            }
        },
        props: {
            patientData: Object
        },
        mounted() {
            // eslint-disable-next-line
            this.updatedPatient = this.patientData;
            this.isDataLoaded = true;
        },
        methods: {
            async editPatient(id) {

                console.log(this.updatedPatient.phoneNumber);
                try {
                    await fetch(`http://localhost:5000/api/patients/${id}`, {
                        method: 'PUT',
                        body: JSON.stringify(this.updatedPatient),
                        headers: {
                            'Access-Control-Allow-Origin': '*',
                            'Content-type': 'application/json; charset=UTF-8'
                        },
                    });

                    alert('successfully edited patient');
                } catch (error) {
                    console.error(error)
                }
            },
            async deletePatient(id) {
                try {
                    await fetch(`http://localhost:5000/api/patients/${id}`, {
                        method: "DELETE"
                    });

                } catch (error) {
                    console.error(error);
                }
                this.$emit('close');

            }
        }
    }
</script>

<style scoped>
    .modal {
        display: none;
        position: fixed;
        z-index: 1;
        padding-top: 100px;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto;
        background-color: rgb(0, 0, 0);
        background-color: rgba(0, 0, 0, 0.4);
    }


    /* Modal Content */

    .modal-content {
        position: relative;
        background-color: #fefefe;
        margin: auto;
        padding: 0;
        border: 1px solid #888;
        width: 80%;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        -webkit-animation-name: animatetop;
        -webkit-animation-duration: 0.4s;
        animation-name: animatetop;
        animation-duration: 0.4s
    }

    .close {
        color: white;
        float: right;
        font-size: 28px;
        font-weight: bold;
    }

    .close:hover,
    .close:focus {
        color: #000;
        cursor: pointer;
    }

    .close a {
        text-decoration: none;

    }


    .modal-body {
        padding: 2px 16px;
    }


    table {
        border-collapse: collapse;
        border-spacing: 0;
        width: 100%;
        border: 1px solid #ddd;
    }

    td {
        text-align: left;
        padding: 8px;
    }

    tr:nth-child(odd) {
        background-color: #f2f2f2;
        font-weight: bolder;
    }

    .button-row {
        padding: 10px;
        display: flex;
        justify-content: space-around;
    }

</style>
