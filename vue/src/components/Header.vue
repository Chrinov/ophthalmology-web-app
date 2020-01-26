<template>
    <div>
        <div class="header-layout">

            <div class="logo">
                <a href="#"> <img alt="Opticus" src="@/assets/opticus-logo.png"> </a>
            </div>

            <div class="phone-number">
                <a href="#"><i class="glyphicon glyphicon-earphone"></i> : +48 123-567-890</a>
            </div>

        </div>

    </div>
</template>

<script>
    export default {
        name: "Header"
    }
</script>

<style scoped>

    .header-layout {
        background-color: #f7f7f2;
    }

    .logo {
        padding: 20px;
        box-sizing: border-box;
        margin-bottom: 20px;
        flex: 3;
    }

    .logo img {
        width: 100%;
        height: auto;
    }

    .phone-number {
        padding: 20px;
        margin-bottom: 20px;
        display: none;
    }

    .phone-number a {
        color: black;
        text-decoration: none;
        font-weight: bold;
        font-size: 2vw;
        white-space: nowrap;
        overflow: hidden;
    }

    @media (min-width: 900px) {
        .header-layout {
            display: flex;
            justify-content: space-between;
        }

        .phone-number {
            flex: 1;
            display: block;
        }

        .logo img {
            width: 50%;
            height: auto;
        }

    }


</style>
