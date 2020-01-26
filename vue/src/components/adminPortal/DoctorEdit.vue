<template>
    <div>
        <div class="modal" style="display: inline">

            <!-- Modal content -->
            <div class="modal-content">
                <div class="modal-body">


                    <div style="overflow-x:auto;">
                        <table v-if="isDataLoaded">
                            <tr>
                                <td>Title</td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="text" v-model="updatedDoctor.title">
                                </td>
                            </tr>
                            <tr>
                                <td>First name</td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="text" v-model="updatedDoctor.firstName">

                                </td>
                            </tr>
                            <tr>
                                <td>Last Name</td>
                            </tr>

                            <tr>
                                <td>
                                    <input type="text" v-model="updatedDoctor.lastName">

                                </td>
                            </tr>

                            <tr>
                                <td>Email</td>
                            </tr>

                            <tr>
                                <td>
                                    <input type="text" v-model="updatedDoctor.email">

                                </td>
                            </tr>

                            <tr>
                                <td>Specialisation</td>
                            </tr>

                            <tr>
                                <td>
                                    <input type="text" v-model="updatedDoctor.specialisation">

                                </td>
                            </tr>

                            <tr>
                                <td>Description</td>
                            </tr>

                            <tr>
                                <td>
                                    <input type="text" v-model="updatedDoctor.description">

                                </td>
                            </tr>

                            <tr>
                                <td>Hire date</td>
                            </tr>

                            <tr>
                                <td>
                                    <input type="datetime-local" v-model="updatedDoctor.hireDate">

                                </td>
                            </tr>

                            <tr>
                                <td>Fire date</td>
                            </tr>

                            <tr>
                                <td>
                                    <input type="datetime-local" v-model="updatedDoctor.fireDate">

                                </td>
                            </tr>

                            <tr>
                                <td>Rating</td>
                            </tr>

                            <tr>
                                <td>
                                    <input type="text" v-model="updatedDoctor.rating">

                                </td>
                            </tr>


                        </table>
                    </div>


                    <div class="button-row">
                        <button @click="editDoctor(updatedDoctor.id)">SAVE</button>
                        <button @click="$emit('close')">CANCEL</button>
                        <button @click="deleteDoctor(updatedDoctor.id)">DELETE DOCTOR</button>
                    </div>

                </div>
            </div>

        </div>

    </div>
</template>

<script>
    /* eslint-disable */

    export default {
        name: "DoctorEdit",
        data() {
            return {
                doctors: [],
                isDataLoaded: false,
                updatedDoctor: Object

            }
        },
        props: {
            doctorData: Object
        },
        mounted() {
            // eslint-disable-next-line
            this.updatedDoctor = this.doctorData;
            this.isDataLoaded = true;
        },
        methods: {
            async editDoctor(id) {

                console.log(this.updatedDoctor.phoneNumber);
                try {
                    await fetch(`http://localhost:5000/api/doctors/${id}`, {
                        method: 'PUT',
                        body: JSON.stringify(this.updatedDoctor),
                        headers: {'Content-type': 'application/json; charset=UTF-8'},
                    });

                    alert('successfully edited doctor');
                } catch (error) {
                    console.error(error)
                }
            },
            async deleteDoctor(id) {
                try {
                    await fetch(`http://localhost:5000/api/doctors/${id}`, {
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
