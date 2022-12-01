<?php

namespace App\Controller;



use Exception;
use MessageBird\Client;

use Courier\CourierClient;

use App\Entity\Offredemploi;
use App\Form\OffredemploiType;
use MessageBird\Objects\Message;
use PHPMailer\PHPMailer\PHPMailer;
use App\Repository\OffredemploiRepository;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;
use Knp\Component\Pager\PaginatorInterface;
use phpDocumentor\Reflection\Types\Integer;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;



#[Route('/offredemploi')]
class OffredemploiController extends AbstractController
{

    #[Route('/dashboard', name: 'app_offredemploi_index')]
    public function index(OffredemploiRepository $offredemploiRepository, Request $request, PaginatorInterface $paginator): Response
    {
        $selected_val = 10;
        if (isset($_POST['submit'])) {
            $selected_val = $_POST['state'];
        }

        $data = $offredemploiRepository->findAll();
        $dataf = $paginator->paginate(
            $data,
            $request->query->getInt('page', 1),
            $selected_val
        );

        if (isset($_GET['user'])) {
            $user = (string) trim($_GET['user']);
        }
        $entityManager = $this->getDoctrine()->getManager();
        $product = $entityManager->getRepository(Offredemploi::class)->find($user);





        return $this->render('offredemploi/index.html.twig', [
            'offredemplois' => $dataf, 'product' => $product,
        ]);
    }


    #[Route('/dashboard/new', name: 'app_offredemploi_new', methods: ['GET', 'POST'])]
    public function new(Request $request, OffredemploiRepository $offredemploiRepository): Response
    {
        $offredemploi = new Offredemploi();
        $form = $this->createForm(OffredemploiType::class, $offredemploi);
        $form->handleRequest($request);
        $data = $offredemploiRepository->findAll();
        if ($form->isSubmitted() && $form->isValid()) {
            $offredemploiRepository->save($offredemploi, true);





            return $this->redirectToRoute('app_offredemploi_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('offredemploi/new.html.twig', [
            'offredemplois' => $offredemploi,
            'form' => $form,
        ]);
    }

    #[Route('/{id}', name: 'app_offredemploi_show', methods: ['GET'])]
    public function show(Offredemploi $offredemploi): Response
    {
        return $this->render('offredemploi/show.html.twig', [
            'offredemploi' => $offredemploi,
        ]);
    }

    #[Route('/{id}/edit', name: 'app_offredemploi_edit', methods: ['GET', 'POST'])]
    public function edit(Request $request, Offredemploi $offredemploi, OffredemploiRepository $offredemploiRepository): Response
    {
        $form = $this->createForm(OffredemploiType::class, $offredemploi);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $offredemploiRepository->save($offredemploi, true);

            return $this->redirectToRoute('app_offredemploi_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('offredemploi/edit.html.twig', [
            'offredemploi' => $offredemploi,
            'form' => $form,
        ]);
    }

    #[Route('/{id}', name: 'app_offredemploi_delete', methods: ['POST'])]
    public function delete(Request $request, Offredemploi $offredemploi, OffredemploiRepository $offredemploiRepository): Response
    {
        if ($this->isCsrfTokenValid('delete' . $offredemploi->getId(), $request->request->get('_token'))) {
            $offredemploiRepository->remove($offredemploi, true);
        }

        return $this->redirectToRoute('app_offredemploi_index', [], Response::HTTP_SEE_OTHER);
    }
}
