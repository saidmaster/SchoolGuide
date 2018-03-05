$(document).ready(function() {

    // scroll to the specific element
  $(".nav_about").on("click", function() {

        $('html, body').animate({
                    scrollTop: $(".toggle_about").offset().top
                }, 2000);
  });

  $(".nav_bc").on("click", function() {

        $('html, body').animate({
                    scrollTop: $(".toggle_bc").offset().top
                }, 2000);
  });

  $(".nav_func").on("click", function() {

        $('html, body').animate({
                    scrollTop: $(".toggle_func").offset().top
                }, 2000);
  });

  $(".nav_obj").on("click", function() {

        $('html, body').animate({
                    scrollTop: $(".toggle_obj").offset().top
                }, 2000);
  });

  $(".toggle_bc").click(function (){
      $(".infoShowb").toggle(500);
  });

  $(".toggle_func").click(function (){
      $(".infoShowf").toggle(500);
  });

  $(".toggle_obj").click(function (){
      $(".infoShowo").toggle(500);
  });
  $(".toggle_about").click(function (){
      $(".infoShowa").toggle(500);
  });
});