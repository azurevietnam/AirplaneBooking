// contains booking summary reusable code
var booking = function () {

    // representation of money sign ascii code. Code will validate against this 
    var moneySigns = [new MoneyType(0, false, 'VND'), new MoneyType(36, true, 'USD'), new MoneyType(128, true, 'EUR')];     // [36, 128];

    // updates the grand total on the booking summary bar
    updateGrandTotal = function () {
        var grandTotal = 0;
        var i = 0;
        var moneyType;

        for (i = 1; i < 11; i++) {
            var legBSTotal = 0;

            if ($('#Leg' + i + 'BookingSummary').length > 0) {
                legBSTotal = $('#Leg' + i + 'BSTotalFare').html().replace(/,/gi, '').split(" ")[0];
                legBSTotal = ((legBSTotal == '') ? 0 : legBSTotal);
            }

            // get money type for formatting
            if (i == 1) {
                moneyType = defineMoneyType(legBSTotal);
            }
            if (moneyType.sign > 0) {
                legBSTotal = legBSTotal.toString().replace(String.fromCharCode(moneyType.sign), '');
            }

            grandTotal = (Number(grandTotal) + Number(legBSTotal));
        }
        $('#BSGrandTotal').html('');
        $('#BSGrandTotal').html(moneyType.toMoneyString(grandTotal));
    };

    // updates all fields that needs to be updated with a map
    update = function (map) {
        var fare = 0;
        var charges = 0;
        var tax = 0;
        var total = 0;
        var moneyType;

        // get all current prices without commas
        fare = $('span#' + map.suffix() + 'BSFare').html().replace(/,/gi, '');
        charges = $('span#' + map.suffix() + 'BSCharges').html().replace(/,/gi, '');
        tax = $('span#' + map.suffix() + 'BSFareTax').html().replace(/,/gi, '');
        total = $('span#' + map.suffix() + 'BSTotalFare').html().replace(/,/gi, '');

        moneyType = defineMoneyType(fare);

        // remove money signs for calculations
        if (moneyType.sign > 0) {
            fare = fare.replace(String.fromCharCode(moneyType.sign), '');
            charges = charges.replace(String.fromCharCode(moneyType.sign), '');
            tax = tax.replace(String.fromCharCode(moneyType.sign), '');
            total = total.replace(String.fromCharCode(moneyType.sign), '');
        }

        // calculate new values
        charges = Number(charges) - Number(map.oldSeatPrice) + Number(map.seatPrice) - Number(map.oldSeatMarkup) + Number(map.seatMarkup);
        tax = Number(tax) - Number(map.oldSeatTax) + Number(map.seatTax) - Number(map.oldSeatMarkupTax) + Number(map.seatMarkupTax);
        total = total - Number(map.oldSeatTax) + Number(map.seatTax) - Number(map.oldSeatMarkupTax) + Number(map.seatMarkupTax) - Number(map.oldSeatPrice) + Number(map.seatPrice) - Number(map.oldSeatMarkup) + Number(map.seatMarkup);

        // set BS bar values back in html
        $('span#' + map.suffix() + 'BSCharges').html(moneyType.toMoneyString(charges));
        $('span#' + map.suffix() + 'BSFareTax').html(moneyType.toMoneyString(tax));
        $('span#' + map.suffix() + 'BSTotalFare').html(moneyType.toMoneyString(total));
    };

    defineMoneyType = function (value) {
        var moneyType;

        // find if first value has a money sign by ascii code
        for (var i = 0; i < moneySigns.length; i++) {
            if (value.charCodeAt(0) == moneySigns[i].sign) {
                moneyType = moneySigns[i];
                break;
            }
        }

        // default to what can assume it is
        if (moneyType == undefined) {
            moneyType = new MoneyType();
            moneyType.sign = 0;
            moneyType.shortCode = 'Default with no money sign';

            // check if has pennies
            if (value.indexOf('.') > -1) {
                moneyType.hasDecimal = true;
            }
        }

        return moneyType;
    };

    return {
        updateGrandTotal: updateGrandTotal,
        update: update,
        getMoneyType: defineMoneyType
    };

} ();

// money class to hold money sign and weather it contains decimal or not
function MoneyType(sign, hasDecimal, shortCode) {
    this.sign = sign;
    this.hasDecimal = hasDecimal;
    this.shortCode = shortCode;

    this.toMoneyString = function (value) {
        return ((this.sign != 0) ? String.fromCharCode(this.sign) : '') + addCommas(((this.hasDecimal) ? parseFloat(value).toFixed(2) : value));
    };
};