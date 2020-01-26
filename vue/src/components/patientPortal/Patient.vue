<template>
    <div>
        First name: {{this.firstName}}
        Last name: {{lastName}}
        <br>
    </div>
</template>

<script>
    export default {
        data() {
            return {

                firstName: "",
                lastName: ""
            }
        }
    }
</script>

<style scoped>

</style>
