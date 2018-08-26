function getTeamsFromSelector() {
    var e = document.getElementById("team1_selector");
    var strTeam1 = e.options[e.selectedIndex].value;

    e = document.getElementById("team2_selector");
    var strTeam2 = e.options[e.selectedIndex].value;

    if ((strTeam1 == "") && (strTeam2 == "")) {
        window.open("./bans/","_self");
    } else if (((strTeam1 != "") && (strTeam2 == "")) || ((strTeam1 == "") && (strTeam2 != ""))) {
        window.open("./bans/"+strTeam1+strTeam2,"_self");
    } else {
        window.open("./bans/"+strTeam1+"/"+strTeam2,"_self");
    }
}

function colorTable() {
    //PICKS table. MAXIMUM picks = good, minimum picks = bad
    $('#picks tr').each(function(){
        var vals = $('td,th',this).map(function () {
            return parseInt($(this).text(), 10) ? parseInt($(this).text(), 10) :  null;
        }).get();
        // then find their minimum
        var minPicks = Math.min.apply(Math, vals);
        var maxPicks = Math.max.apply(Math, vals);

        // tag any cell matching the min value
        $('td,th', this).filter(function () {
            return parseInt($(this).text(), 10) === minPicks;
        }).addClass('alert alert-danger');
        $('td,th', this).filter(function () {
            return parseInt($(this).text(), 10) === 0;
        }).addClass('alert alert-danger');

        $('td,th', this).filter(function () {
            return parseInt($(this).text(), 10) === maxPicks;
        }).addClass('alert alert-success');
    });

    $('#bans tr').each(function(){
        var vals = $('td,th',this).map(function () {
            return parseInt($(this).text(), 10) ? parseInt($(this).text(), 10) :  null;
        }).get();
        var maxBans = Math.max.apply(Math, vals);

        $('td,th', this).filter(function () {
            return parseInt($(this).text(), 10) === maxBans;
        }).addClass('alert alert-danger');
    });

    $('#left tr').each(function(){
        var vals = $('td,th',this).map(function () {
            return parseInt($(this).text(), 10) ? parseInt($(this).text(), 10) :  null;
        }).get();
        var maxleft = Math.max.apply(Math, vals);

        $('td,th', this).filter(function () {
            return parseInt($(this).text(), 10) === maxleft;
        }).addClass('alert alert-info');
    });
}

function hideNames() {
    var rowCount = $('#picks tr').length;
    if (rowCount > 4) {
        $('#header-team1-name').addClass('invisible');
        $('#header-team2-name').addClass('invisible');
    }
}

function drawPicksGraph() {
    var ctx = document.getElementById('picksChart').getContext('2d');
    var team1 = picksvar[0];
    var team2 = picksvar[1];
    var chart = new Chart(ctx, {
        type: 'radar',

        // The data for our dataset
        data: {
            labels: ["d2", "trn", "nuke", "mrg", "inf", "cch", "ovp"],
            datasets: [
                {
                    label: team1.name+"'s picks",
                    backgroundColor: 'rgba(3, 87, 255, 0.6)',
                    borderColor: 'rgb(0, 125, 255,)',
                    data: [team1.d2,team1.trn,team1.nuke,team1.mrg,team1.inf,team1.cch,team1.ovp],
                },
                {
                    label: team2.name+"'s picks",
                    backgroundColor: 'rgba(255, 129, 3, 0.75)',
                    borderColor: 'rgb(255, 125, 0)',
                    data: [team2.d2,team2.trn,team2.nuke,team2.mrg,team2.inf,team2.cch,team2.ovp],
                }]
        },

        // Configuration options go here
        options: {}
    });
}

function drawBansChart() {
    var ctx = document.getElementById('bansChart').getContext('2d');
    var team1 = bansvar[0];
    var team2 = bansvar[1];
    var chart = new Chart(ctx, {
        type: 'radar',

        // The data for our dataset
        data: {
            labels: ["d2", "trn", "nuke", "mrg", "inf", "cch", "ovp"],
            datasets: [
                {
                    label: team1.name+"'s BANS",
                    backgroundColor: 'rgba(3, 87, 255, 0.6)',
                    borderColor: 'rgb(0, 125, 255,)',
                    data: [team1.d2,team1.trn,team1.nuke,team1.mrg,team1.inf,team1.cch,team1.ovp],
                },
                {
                    label: team2.name+"'s BANS",
                    backgroundColor: 'rgba(255, 129, 3, 0.75)',
                    borderColor: 'rgb(255, 125, 0)',
                    data: [team2.d2,team2.trn,team2.nuke,team2.mrg,team2.inf,team2.cch,team2.ovp],
                }]
        },

        // Configuration options go here
        options: {}
    });
}

/* IF ONE TEAM */
function drawPicksGraph_1() {
    var ctx = document.getElementById('picksChart').getContext('2d');
    var team1 = picksvar[0];
    var team2 = picksvar[1];
    var chart = new Chart(ctx, {
        type: 'radar',

        // The data for our dataset
        data: {
            labels: ["d2", "trn", "nuke", "mrg", "inf", "cch", "ovp"],
            datasets: [
                {
                    label: team1.name+"'s picks",
                    backgroundColor: 'rgba(3, 87, 255, 0.6)',
                    borderColor: 'rgb(0, 125, 255,)',
                    data: [team1.d2,team1.trn,team1.nuke,team1.mrg,team1.inf,team1.cch,team1.ovp],
                }]
        },

        // Configuration options go here
        options: {}
    });
}

function drawBansChart_1() {
    var ctx = document.getElementById('bansChart').getContext('2d');
    var team1 = bansvar[0];
    var team2 = bansvar[1];
    var chart = new Chart(ctx, {
        type: 'radar',

        // The data for our dataset
        data: {
            labels: ["d2", "trn", "nuke", "mrg", "inf", "cch", "ovp"],
            datasets: [
                {
                    label: team1.name+"'s BANS",
                    backgroundColor: 'rgba(3, 87, 255, 0.6)',
                    borderColor: 'rgb(0, 125, 255,)',
                    data: [team1.d2,team1.trn,team1.nuke,team1.mrg,team1.inf,team1.cch,team1.ovp],
                }]
        },

        // Configuration options go here
        options: {}
    });
}

$( document ).ready(function() {
    console.log( "ready!" );
    colorTable();
    hideNames();

    if (bansvar.length === 2) {
        drawPicksGraph();
        drawBansChart();
    }
    if (bansvar.length === 1) {
        drawBansChart_1();
        drawPicksGraph_1();
    }
});

