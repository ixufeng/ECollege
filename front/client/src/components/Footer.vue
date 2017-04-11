<template lang="html">
    <div class="footer">
        <el-row style="background-color: #2c333d; height: 300px;" :gutter="20">
             <el-col :offset="2" :span="6">
                <div class="foot-con">
                    <h2 class="h2">NEWSLETTER</h2>
                    <span class="foot-text">Lorem ipsum dolor sit amet, tristique nec libero. Proin vitae convallis odio. Morbi nec enim nisi. Aliquam erat volutpat.</span>
                </div>
             </el-col>
             <el-col :span="6">
                 <div class="foot-con">
                     <h2 class="h2">NEWSLETTER</h2>
                     <span class="foot-text">Lorem ipsum dolor sit amet, tristique nec libero. Proin vitae convallis odio. Morbi nec enim nisi. Aliquam erat volutpat.</span>
                 </div>
             </el-col>
             <el-col :span="6">
                 <div class="foot-con">
                     <h2 class="h2">NEWSLETTER</h2>
                     <span class="foot-text">Lorem ipsum dolor sit amet, tristique nec libero. Proin vitae convallis odio. Morbi nec enim nisi. Aliquam erat volutpat.</span>
                 </div>
             </el-col>
        </el-row>
        <el-row style="background: #131313;">
            <el-col :span="20">
                <div class="foot-bottom">
                    <div class="footer-nav">
                        <ul>
                            <li><a class="scroll" href="#movetop">Home <span class="sr-only">(current)</span></a></li>
                            <li><a href="about.html">ABOUT</a></li>
                            <li><a href="typography.html">Short codes</a></li>
                            <li><a href="gallery.html">GALLERY</a></li>
                            <li><a href="blog.html">Blog</a></li>
                            <li><a href="contact.html">Contact Us</a></li>
                        </ul>
                    </div>
                </div>
            </el-col>
        </el-row>

  	</div>
</template>

<script>
export default {
}
</script>

<style lang="css">

    .footer{
        width: 100%;
    }
    .foot-con{
        padding: 50px;
    }
    .h2{
        font-size: 1.6em;
        color: #fff;
        font-weight: 400;
        text-transform: uppercase;
        margin-bottom: 0.5em;
    }
    .foot-text{
        font-size: 0.95em;
        line-height: 1.8em;
        color: #BFBFBF;
        font-weight: 400;
    }
    .foot-bottom{
        padding-right: 60px;
        width: 100%;
        height: 50px;
        padding: 1.8em 0;
    }
    .footer-nav {
    float: right;
    }
    .footer-nav ul li {
    	margin:0 0.5em;
        display:inline-block;
    }
    .footer-nav ul li a {
    	text-decoration:none;
    	text-transform:uppercase;
    	color:#898989;
    	font-size:0.95em;
    }
    .footer-nav ul li a:hover {
    	color:#fff;
    }

</style>
