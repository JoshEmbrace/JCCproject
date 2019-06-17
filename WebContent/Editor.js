 document.execCommand('styleWithCSS', false, true);
  document.execCommand('insertBrOnReturn', false, true);
  $(document).ready(function() {
    $("#text").focus();
    $('button').click(function(){
      document.execCommand($(this).attr('id'), false, true);
    });
    $('select').change(function(){
      document.execCommand($(this).attr('id'), false, $(this).val());
    });
     $("#foreColor").change(function(){ 
       document.execCommand('foreColor', false, $(this).val());
     });
     $("#hiliteColor").change(function(){
       document.execCommand('hiliteColor', false, $(this).val());
     });
     $("#fontName").change(function(){
       document.execCommand('fontName', false, $(this).val());
     });
     $("#fontSize").change(function(){
       document.execCommand('fontSize', false, $(this).val());
     });
    
  });
  
  