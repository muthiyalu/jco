
var homeBot = BotUI('home-demo');

homeBot.message.add({
  content: 'Hello there! ' + global_username
}).then(function () {
  return homeBot.message.add({
    delay: 1500,
    content: 'First we need to setup a folder in your drive to store all your docs'
  });
}).then(function () {
  return homeBot.action.button({
    delay: 1000,
    action: [{
      text: 'Sure!',
      value: 'sure'
    }, {
      text: 'Tell me more ',
      value: 'tellmemore'
    }]
  });
}).then(function (res) {
  if(res.value == 'sure') {
    createDrive();
  }
  if(res.value == 'tellmemore') {
    tellmemore();
  }
});



var tutorial = function () {


  homeBot.message.add({
    delay: 1000,
    content: "Awesome! You can show buttons like the one you pressed."
  }).then(function () {
    return homeBot.message.add({
      delay: 1000,
      content: 'You can ask for text input like ..'
    });
  }).then(function () {
    return homeBot.message.add({
      delay: 1200,
      content: 'Whats your name?'
    });
  }).then(function () {
    return homeBot.action.text({
      delay: 800,
      action: {
        value: 'John Doe',
        placeholder: 'Your name'
      }
    });
  }).then(function (res) {
    return homeBot.message.bot({
      delay: 500,
      content: res.value + ' is a nice name!'
    });
  }).then(function (res) {
    return homeBot.message.bot({
      delay: 1400,
      content: 'You can also embed something from 3rd party'
    });
  }).then(function (res) {
    return homeBot.message.add({
      delay: 1200,
      type: 'embed',
      content: 'https://giphy.com/embed/v1PSPwbLIrata'
    });
  }).then(function (res) {
    return homeBot.message.bot({
      delay: 2500,
      content: 'There is a lot more you can do with BotUI'
    });
  }).then(function (res) {
    return homeBot.message.bot({
      delay: 1000,
      content: 'Now go on, explore the docs and build yourself a bot.'
    });
  });
};
var tellmemore = function () {
  homeBot.message.add({
    delay: 500,
    content: '!(book) [Read why we need to create a folder](https:///docs.botui.org), and see our privacy and security policies to keep you safe [examples](https:///examples.botui.org) or explore the code on !(github) [GitHub](https://github.com/moinism/botui)'
  }).then(function () {
      return homeBot.action.button({
        delay: 500,
        action: [{
          text: 'Read the docs, lets go!',
          value: 'sre'
        }, {
          text: ' No thanks sign me out ',
          value: 'tellmemore'
        }]
      });
    }).then(function (res) {
         if(res.value == 'sure') {
           tutorial();
         }
         if(res.value == 'signout') {
           signout();
         }
       });
};

var createDrive= function (){


    $.post("/createdrive",
    {
        name: global_username
    },
    function(data, status){


             alert("Data: " + data + "\nStatus: " + status);


        if (data=="ROOT_FOLDER_CREATION_SUCCESS"){

        tutorial();

         alert("Data: " + data + "\nStatus: " + status);


        }else if (data=="ROOT_FOLDER_EXISTS"){

         alert("Data: " + data + "\nStatus: " + status);



        }else if (data=="ROOT_FOLDER_CREATION_FAILURE") {


        }


    });


}