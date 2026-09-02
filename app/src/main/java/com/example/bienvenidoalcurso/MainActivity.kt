package com.example.bienvenidoalcurso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bienvenidoalcurso.ui.theme.BienvenidoAlCursoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BienvenidoAlCursoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ExploracionComponentesScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExploracionComponentesScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { ComponenteLazyColumn() }
        item { ComponenteLazyRow() }
        item { ComponenteGrid() }
        item { ComponenteScaffold() }
        item { ComponenteSurface() }
        item { ComponenteChip() }
        item { ComponenteFlowRow() }
        item { ComponenteFlowColumn() }
        item { ComponenteAlertDialog() }
        item { ComponenteCard() }
        item { ComponenteCheckbox() }
        item { ComponenteFloatingActionButton() }
        item { ComponenteIconAndImage() }
        item { ComponenteProgressBar() }
        item { ComponenteRadioButton() }
        item { ComponenteSlider() }
        item { ComponenteSpacer() }
        item { ComponenteSwitch() }
        item { ComponenteTopAppBar() }
        item { ComponenteBottomNavigation() }
        item { ComponenteDialog() }
        item { ComponenteDivider() }
        item { ComponenteDropDownMenu() }
        item { ComponenteNavigationRail() }
        item { ComponenteOutlinedTextField() }
        item { ComponentePager() }
        item { ComponenteSnackbar() }
        item { ComponenteTabRow() }
        item { ComponenteTooltip() }
    }
}

// ---------------- CONTENEDORES Y CONTROLES ----------------

@Preview(showBackground = true)
@Composable
fun ComponenteLazyColumn() {
    Column {
        Text("LazyColumn", fontWeight = FontWeight.Bold)
        LazyColumn(modifier = Modifier.height(80.dp)) {
            items(3) { Text("Elemento de lista vertical $it") }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComponenteLazyRow() {
    Column {
        Text("LazyRow", fontWeight = FontWeight.Bold)
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(5) { Button(onClick = {}) { Text("Item $it") } }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComponenteGrid() {
    Column {
        Text("LazyVerticalGrid", fontWeight = FontWeight.Bold)
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.height(100.dp)
        ) {
            items(4) { Card(modifier = Modifier.padding(4.dp)) { Text("Grid $it", modifier = Modifier.padding(8.dp)) } }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ComponenteScaffold() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejemplo Scaffold", fontSize = 16.sp) }
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("Contenido dentro de Scaffold")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComponenteSurface() {
    Surface(
        color = MaterialTheme.colorScheme.primaryContainer,
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(8.dp)
    ) {
        Text("Contenido dentro de Surface", modifier = Modifier.padding(16.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ComponenteChip() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        AssistChip(
            onClick = {},
            label = { Text("Assist Chip") },
            leadingIcon = { Icon(Icons.Default.Info, contentDescription = null) }
        )
    }
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ComponenteFlowRow() {
    FlowRow(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        repeat(4) { index ->
            FilterChip(
                selected = false,
                onClick = {},
                label = { Text("Tag $index") }
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Preview(showBackground = true)
@Composable
fun ComponenteFlowColumn() {
    FlowColumn(modifier = Modifier.height(100.dp)) {
        repeat(3) { Text("Columna $it") }
    }
}

@Preview(showBackground = true)
@Composable
fun ComponenteAlertDialog() {
    var openDialog by remember { mutableStateOf(false) }

    Column {
        Button(onClick = { openDialog = true }) {
            Text("Mostrar AlertDialog")
        }

        if (openDialog) {
            AlertDialog(
                onDismissRequest = { openDialog = false },
                confirmButton = {
                    TextButton(onClick = { openDialog = false }) {
                        Text("OK")
                    }
                },
                title = { Text("AlertDialog") },
                text = { Text("Mensaje de confirmación o alerta.") }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComponenteCard() {
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Text("Tarjeta Informativa (Card)", modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ComponenteCheckbox() {
    var checked by remember { mutableStateOf(true) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked, onCheckedChange = { checked = it })
        Text("Aceptar Términos")
    }
}

@Preview(showBackground = true)
@Composable
fun ComponenteFloatingActionButton() {
    FloatingActionButton(onClick = {}) {
        Icon(Icons.Default.Add, contentDescription = "Agregar")
    }
}

@Preview(showBackground = true)
@Composable
fun ComponenteIconAndImage() {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        Icon(Icons.Default.Home, contentDescription = "Inicio")
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Imagen", modifier = Modifier.size(40.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ComponenteProgressBar() {
    Column {
        LinearProgressIndicator(progress = { 0.7f })
        Spacer(modifier = Modifier.height(8.dp))
        CircularProgressIndicator()
    }
}

@Preview(showBackground = true)
@Composable
fun ComponenteRadioButton() {
    var selected by remember { mutableStateOf(true) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = selected, onClick = { selected = !selected })
        Text("Opción 1")
    }
}

@Preview(showBackground = true)
@Composable
fun ComponenteSlider() {
    var value by remember { mutableFloatStateOf(0.5f) }
    Slider(value = value, onValueChange = { value = it })
}

@Preview(showBackground = true)
@Composable
fun ComponenteSpacer() {
    Row {
        Text("Texto 1")
        Spacer(modifier = Modifier.width(20.dp))
        Text("Texto 2 con Espacio")
    }
}

@Preview(showBackground = true)
@Composable
fun ComponenteSwitch() {
    var checked by remember { mutableStateOf(true) }
    Switch(checked = checked, onCheckedChange = { checked = it })
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ComponenteTopAppBar() {
    TopAppBar(
        title = { Text("Mi Aplicación") },
        navigationIcon = { IconButton(onClick = {}) { Icon(Icons.Default.Menu, contentDescription = null) } }
    )
}

@Preview(showBackground = true)
@Composable
fun ComponenteBottomNavigation() {
    NavigationBar {
        NavigationBarItem(selected = true, onClick = {}, icon = { Icon(Icons.Default.Home, null) }, label = { Text("Inicio") })
        NavigationBarItem(selected = false, onClick = {}, icon = { Icon(Icons.Default.Person, null) }, label = { Text("Perfil") })
    }
}

@Preview(showBackground = true)
@Composable
fun ComponenteDialog() {
    Surface(shape = MaterialTheme.shapes.medium, color = Color.White, modifier = Modifier.padding(16.dp)) {
        Text("Contenido de un Ventana emergente (Dialog)", modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ComponenteDivider() {
    Column {
        Text("Arriba del divisor")
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Text("Debajo del divisor")
    }
}

@Preview(showBackground = true)
@Composable
fun ComponenteDropDownMenu() {
    var expanded by remember { mutableStateOf(true) }
    Box {
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(text = { Text("Opción A") }, onClick = {})
            DropdownMenuItem(text = { Text("Opción B") }, onClick = {})
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComponenteNavigationRail() {
    NavigationRail {
        NavigationRailItem(selected = true, onClick = {}, icon = { Icon(Icons.Default.Home, null) })
        NavigationRailItem(selected = false, onClick = {}, icon = { Icon(Icons.Default.Settings, null) })
    }
}

@Preview(showBackground = true)
@Composable
fun ComponenteOutlinedTextField() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Campo con Borde (Outlined)") }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun ComponentePager() {
    val pagerState = rememberPagerState(pageCount = { 3 })
    HorizontalPager(state = pagerState, modifier = Modifier.height(50.dp)) { page ->
        Text("Página actual: $page", modifier = Modifier.fillMaxWidth())
    }
}

@Preview(showBackground = true)
@Composable
fun ComponenteSnackbar() {
    Snackbar(action = { TextButton(onClick = {}) { Text("Deshacer") } }) {
        Text("Mensaje temporal de notificación (Snackbar)")
    }
}

@Preview(showBackground = true)
@Composable
fun ComponenteTabRow() {
    TabRow(selectedTabIndex = 0) {
        Tab(selected = true, onClick = {}, text = { Text("Tab 1") })
        Tab(selected = false, onClick = {}, text = { Text("Tab 2") })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ComponenteTooltip() {
    TooltipBox(
        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
        tooltip = { PlainTooltip { Text("Información descriptiva") } },
        state = rememberTooltipState()
    ) {
        IconButton(onClick = {}) { Icon(Icons.Default.Info, contentDescription = null) }
    }
}