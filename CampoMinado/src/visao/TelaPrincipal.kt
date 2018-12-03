package visao

import modelo.CampoEvento
import modelo.Tabuleiro
import modelo.TabuleiroEvento
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.SwingUtilities

fun main(args: Array<String>) {
    TelaPrincipal()
}

class TelaPrincipal : JFrame () {
    private val tabuleiro = Tabuleiro(qtdeLinhas = 16, qtdeColunas = 30, qtdeMinas = 89)
    private val painelTabuleiro = Painelabuleiro(tabuleiro)

    init {
        tabuleiro.onEvento(this::mostrarResultado)
        add(painelTabuleiro)

        setSize(1024, 768)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
        title = "CAMPO MINADO"
        isVisible = true
    }

    private fun mostrarResultado(evento: TabuleiroEvento){
        SwingUtilities.invokeLater {
            val msg = when(evento) {
                TabuleiroEvento.VITORIA -> "Você ganhou!"
                TabuleiroEvento.DERROTA -> "Você perdeu... :P"
            }

            JOptionPane.showMessageDialog( this, msg)
            tabuleiro.reiniciar()

            painelTabuleiro.repaint()
            painelTabuleiro.validate()
        }
    }
}