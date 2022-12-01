<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class OffredempController extends AbstractController
{
    #[Route('/offredemp', name: 'app_offredemp')]
    public function index(): Response
    {


        return $this->render('offredemp/index.html.twig', [
            'controller_name' => 'OffredempController',
        ]);
    }
}
