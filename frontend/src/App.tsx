import HeaderComponent from './components/Header'
import NotificationButton from './components/NotificationButton'
import SalesCardComponent from './components/SalesCard'

function App() {
  return (
    <>
   
    <HeaderComponent/>
    <main>
        <section id="sales">
            <div className='dsmeta-container'>

            </div>
        </section>
    </main>
    <SalesCardComponent />
    <NotificationButton/>
    </>
    
  )

}

export default App
