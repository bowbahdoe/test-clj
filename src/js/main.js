window.deps = {
    'react' : require('react'),
    'react-dom' : require('react-dom'),
    'react-player' : require('react-player'),
    'material-ui' : require('material-ui'),
};

window.React = window.deps['react'];
window.ReactDOM = window.deps['react-dom'];
require('react-tap-event-plugin')();

// Needed for onTouchTap
// http://stackoverflow.com/a/34015469/988941


console.log("Loaded Foreign Dependencies");
process.env = 'production'
