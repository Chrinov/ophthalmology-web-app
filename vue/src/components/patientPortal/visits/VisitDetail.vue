<template>
    <div>
        <div class="modal" style="display: inline">

            <!-- Modal content -->
            <div class="modal-content">
                <div class="modal-body">
                    <span class="close" style="color: black;"><a @click="$emit('close')">x</a> </span>


                    <div style="overflow-x:auto;">
                        <table>
                            <tr>
                                <td>Date</td>
                            </tr>
                            <tr>
                                <td>{{visitData.date}}</td>
                            </tr>
                            <tr>
                                <td>Doctor</td>
                            </tr>
                            <tr>
                                <td>{{visitData.specialist.title}} {{visitData.specialist.firstName}}
                                    {{visitData.specialist.lastName}}
                                </td>
                            </tr>
                            <tr>
                                <td>Address</td>
                            </tr>

                            <tr>
                                <td>{{visitData.clinic}}</td>
                            </tr>

                            <tr>
                                <td>Visit type</td>
                            </tr>

                            <tr>
                                <td>{{visitData.visitType}}</td>
                            </tr>

                            <tr>
                                <td>Reason</td>
                            </tr>

                            <tr>
                                <td>{{visitData.reason}}</td>
                            </tr>

                            <tr>
                                <td>Description</td>
                            </tr>

                            <tr>
                                <td>{{visitData.description}}</td>
                            </tr>


                        </table>
                    </div>


                </div>
            </div>

        </div>

    </div>
</template>

<script>
    export default {
        name: "VisitDetail",
        props: {
            visitData: Object
        },
        mounted() {
            // eslint-disable-next-line
            console.log(this.visitData);
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

</style>
