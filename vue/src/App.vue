<template>
    <div id="app">


        <Header/>
        <Navbar/>
        <router-view/>

        <Footer/>


    </div>
</template>

<style>
    div {
        position: relative;

    }

    body {
        max-width: 120rem;
        margin: 8rem auto;
        min-height: 50rem;
    }

    @media only screen and (max-width: 75em) {

        body {
            margin: 0;
            max-width: 100%;
            width: 100%;
        }

    }

    * {
        font-family: "Segoe UI";
    }

</style>
<script>
    import Header from "@/components/Header";
    import Footer from "@/components/Footer";
    import Navbar from "@/components/Navbar";

    export default {
        components: {Navbar, Footer, Header}
    }
</script>
