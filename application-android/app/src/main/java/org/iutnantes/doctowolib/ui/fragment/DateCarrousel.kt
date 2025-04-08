package org.iutnantes.doctowolib.ui.fragment

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import org.iutnantes.doctowolib.ui.theme.ACCENT_PINK
import org.iutnantes.doctowolib.ui.theme.DATE_CARROUSEL_BACKGROUND
import org.iutnantes.doctowolib.ui.theme.PRIMARY_PINK
import org.iutnantes.doctowolib.ui.theme.BLACK
import org.iutnantes.doctowolib.ui.theme.BORDER_RADIUS
import org.iutnantes.doctowolib.ui.theme.DATE_SIZE
import org.iutnantes.doctowolib.ui.theme.REALLY_SMALL_PADDING
import org.iutnantes.doctowolib.ui.theme.SMALL_PADDING
import org.iutnantes.doctowolib.ui.theme.WHITE
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale

data class DateItem(
    val dayNumber: Int,
    val dayName: String
)

/**
 * Returns a list of all the days and their corresponding day names for the current month.
 *
 * The function retrieves the current date, determines the number of days in the current month,
 * and creates a list of `DateItem` objects. Each `DateItem` contains the day number and the full name
 * of the corresponding day of the week in French.
 *
 * @return A list of `DateItem` objects, where each object contains:
 * - `day` (Int): The day number of the month (e.g., 1, 2, ..., 31).
 * - `dayName` (String): The full name of the day of the week in French (e.g., "lundi", "mardi").
 *
 * Example output for January 2025:
 * ```
 * [
 *   DateItem(1, "mercredi"),
 *   DateItem(2, "jeudi"),
 *   ...
 *   DateItem(31, "vendredi")
 * ]
 * ```
 *
 * Note: The function uses the system's default time zone to determine the current date.
 */
fun getDaysAndNamesOfCurrentMonth(): List<DateItem> {
    val currentDate = LocalDate.now()
    val currentYearMonth = YearMonth.from(currentDate)
    val daysInMonth = currentYearMonth.lengthOfMonth()

    return (1..daysInMonth).map { day ->
        val date = LocalDate.of(currentYearMonth.year, currentYearMonth.month, day)
        val dayName = date.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.FRANCE)
        DateItem(day, dayName)
    }
}

/**
 * Returns the zero-based index of the current day of the month.
 *
 * @return The current day of the month as a zero-based index (e.g., 14 for the 15th day).
 */
fun getCurrentDay(): Int {
    val currentDate = LocalDate.now()
    return currentDate.dayOfMonth - 1
}

@Preview(showBackground = true)
@Composable
fun dateCarrousel() : Int {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    val daysOfMonth = remember { getDaysAndNamesOfCurrentMonth() }
    val activeDay = remember { getCurrentDay() }

    var selectedIndex by remember {
        mutableIntStateOf(activeDay)
    }

    LaunchedEffect(Unit) {
        coroutineScope.run {
            listState.scrollToItem(activeDay)
        }
    }

    LazyRow(state = listState, modifier = Modifier.background(DATE_CARROUSEL_BACKGROUND)) {
        items(daysOfMonth.size) {
            if (it == selectedIndex) {
                DateCarrouselItemSelected(daysOfMonth, it)
            } else {
                DateCarrouselItem(daysOfMonth, it) { selectedIndex = it }
            }
        }
    }
    return selectedIndex+1
}

@Composable
fun DateCarrouselItem(days: List<DateItem>, indexItem: Int, onClick: () -> Unit) {
    val lastPadding = if (indexItem == days.lastIndex) 8 else 4

    Box(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .padding(start = 8.dp, end = lastPadding.dp)
            .padding(vertical = 8.dp)
            .clip(
                RoundedCornerShape(16.dp)
            )
            .background(WHITE)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                days[indexItem].dayNumber.toString(),
                color = BLACK,
                fontSize = TextUnit(36f, TextUnitType.Sp),
                fontWeight = FontWeight.Bold
            )
            Text(
                days[indexItem].dayName,
                color = BLACK,
                fontSize = TextUnit(18f, TextUnitType.Sp)
            )
        }
    }
}

@Composable
fun DateCarrouselItemSelected(days: List<DateItem>, indexItem: Int) {
    val lastPadding = if (indexItem == days.lastIndex) 8 else 4

    Box(
        modifier = Modifier
            .width(DATE_SIZE)
            .height(DATE_SIZE)
            .padding(start = SMALL_PADDING, end = lastPadding.dp)
            .padding(vertical = SMALL_PADDING)
            .clip(
                RoundedCornerShape(BORDER_RADIUS)
            )
            .background(PRIMARY_PINK)
            .border(
                width = REALLY_SMALL_PADDING,
                color = ACCENT_PINK,
                shape = RoundedCornerShape(BORDER_RADIUS)
            )
            .clickable {},
        contentAlignment = Alignment.Center
    ) {

        Box(contentAlignment = Alignment.Center) {
            Text(
                days[indexItem].dayNumber.toString(),
                color = WHITE,
                fontSize = TextUnit(36f, TextUnitType.Sp),
                fontWeight = FontWeight.Black,
                modifier = Modifier.offset(y = ((-12).dp))
            )
            Text(
                days[indexItem].dayName,
                color = WHITE,
                fontSize = TextUnit(20f, TextUnitType.Sp),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.offset(y = 16.dp)
            )
            Box(
                modifier = Modifier
                    .offset(y = 32.dp)
                    .width(35.dp)
                    .height(2.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(ACCENT_PINK)
            )
        }
    }

}