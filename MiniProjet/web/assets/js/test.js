$(".text").click(function(){
    $(".text").hide();
}); 

$(".cancel-btn").click(function(){
    $(".text").show();
});

$('.text').click(function(){
    $(".add-comment").slideToggle();
});


$(".cancel-btn").click(function(){
    $(".add-comment").hide();
});
